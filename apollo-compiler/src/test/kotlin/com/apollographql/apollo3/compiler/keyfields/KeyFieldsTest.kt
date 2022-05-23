package com.apollographql.apollo3.compiler.keyfields

import com.apollographql.apollo3.ast.GQLFragmentDefinition
import com.apollographql.apollo3.ast.GQLOperationDefinition
import com.apollographql.apollo3.ast.checkKeyFields
import com.apollographql.apollo3.ast.parseAsGQLDocument
import com.apollographql.apollo3.ast.transformation.addRequiredFields
import com.apollographql.apollo3.ast.validateAsSchema
import com.apollographql.apollo3.ast.withApolloDefinitions
import com.apollographql.apollo3.compiler.Options.Companion.defaultAddTypename
import com.apollographql.apollo3.compiler.introspection.toSchema
import com.apollographql.apollo3.compiler.introspection.toSchemaGQLDocument
import okio.buffer
import okio.source
import org.junit.Assert.fail
import org.junit.Test
import java.io.File
import kotlin.test.assertContains
import kotlin.test.assertEquals

class KeyFieldsTest {
  @Test
  fun testAddRequiredFields() {
    val schema = File("src/test/kotlin/com/apollographql/apollo3/compiler/keyfields/schema.graphqls").toSchema()

    val definitions = File("src/test/kotlin/com/apollographql/apollo3/compiler/keyfields/operations.graphql")
        .source()
        .buffer()
        .parseAsGQLDocument()
        .valueAssertNoErrors()
        .definitions

    val fragments = definitions.filterIsInstance<GQLFragmentDefinition>().associateBy { it.name }

    val operation = definitions
        .filterIsInstance<GQLOperationDefinition>()
        .first()

    try {
      checkKeyFields(operation, schema, emptyMap())
      fail("an exception was expected")
    } catch (e: Exception) {
      assert(e.message?.contains("are not queried") == true)
    }

    val operationWithKeyFields = addRequiredFields(operation, defaultAddTypename, schema, fragments)
    checkKeyFields(operationWithKeyFields, schema, emptyMap())
  }

  @Test
  fun testExtendInterfaceTypePolicyDirective() {
    val schema = File("src/test/kotlin/com/apollographql/apollo3/compiler/keyfields/extendsSchema.graphqls").toSchema()
    schema.toGQLDocument().validateAsSchema()
    assertEquals(setOf("id"), schema.keyFields("Node"))
  }

  @Test
  fun testExtendUnionTypePolicyDirective() {
    val schema = File("src/test/kotlin/com/apollographql/apollo3/compiler/keyfields/extendsSchema.graphqls").toSchema()
    assertEquals(setOf("x"), schema.keyFields("Foo"))
  }

  @Test
  fun testObjectWithTypePolicyAndInterfaceTypePolicyErrors() {
    val doc = File("src/test/kotlin/com/apollographql/apollo3/compiler/keyfields/objectAndInterfaceTypePolicySchema.graphqls")
        .toSchemaGQLDocument()
        .withApolloDefinitions()
    val issue = doc.validateAsSchema().issues.first()
    assertContains(issue.message, "Type 'Foo' cannot have key fields since it implements")
    assertContains(issue.message, "Node")
    assertEquals(11, issue.sourceLocation.line)
  }
}
