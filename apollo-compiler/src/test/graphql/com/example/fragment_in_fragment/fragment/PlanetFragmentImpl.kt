// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.example.fragment_in_fragment.fragment.adapter.PlanetFragmentImpl_ResponseAdapter
import kotlin.String

/**
 * A large mass, planet or planetoid in the Star Wars Universe, at the time of
 * 0 ABY.
 */
data class PlanetFragmentImpl(
  override val __typename: String = "Planet",
  /**
   * The name of this planet.
   */
  override val name: String?
) : PlanetFragment, GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller {
    return ResponseFieldMarshaller { writer ->
      PlanetFragmentImpl_ResponseAdapter.toResponse(writer, this)
    }
  }
}
