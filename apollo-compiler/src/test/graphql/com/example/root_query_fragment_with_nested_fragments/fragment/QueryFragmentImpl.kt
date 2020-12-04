// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment_with_nested_fragments.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.example.root_query_fragment_with_nested_fragments.fragment.adapter.QueryFragmentImpl_ResponseAdapter
import kotlin.String

/**
 * The query type, represents all of the entry points into our object graph
 */
data class QueryFragmentImpl(
  override val __typename: String = "Query",
  override val hero: Hero?,
  override val droid: Droid?,
  override val human: Human?
) : QueryFragment, GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller {
    return ResponseFieldMarshaller { writer ->
      QueryFragmentImpl_ResponseAdapter.toResponse(writer, this)
    }
  }

  /**
   * A character from the Star Wars universe
   */
  interface Hero : QueryFragment.Hero {
    override val __typename: String

    override fun marshaller(): ResponseFieldMarshaller

    interface Character : QueryFragment.Hero, QueryFragment.Hero.Character, HeroFragment, Hero {
      override val __typename: String

      /**
       * The name of the character
       */
      override val name: String

      override fun marshaller(): ResponseFieldMarshaller
    }

    data class CharacterHero(
      override val __typename: String,
      /**
       * The name of the character
       */
      override val name: String
    ) : QueryFragment.Hero, QueryFragment.Hero.Character, HeroFragment, Hero, Character {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Hero.CharacterHero.toResponse(writer, this)
        }
      }
    }

    /**
     * A character from the Star Wars universe
     */
    data class OtherHero(
      override val __typename: String = "Character"
    ) : QueryFragment.Hero, Hero {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Hero.OtherHero.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun Hero.heroFragment(): HeroFragment? = this as? HeroFragment

      fun Hero.asCharacter(): Character? = this as? Character
    }
  }

  /**
   * An autonomous mechanical character in the Star Wars universe
   */
  interface Droid : QueryFragment.Droid {
    override val __typename: String

    override fun marshaller(): ResponseFieldMarshaller

    interface Droid : QueryFragment.Droid, QueryFragment.Droid.Droid, DroidFragment,
        QueryFragmentImpl.Droid {
      override val __typename: String

      /**
       * What others call this droid
       */
      override val name: String

      /**
       * This droid's primary function
       */
      override val primaryFunction: String?

      override fun marshaller(): ResponseFieldMarshaller
    }

    data class DroidDroid(
      override val __typename: String = "Droid",
      /**
       * What others call this droid
       */
      override val name: String,
      /**
       * This droid's primary function
       */
      override val primaryFunction: String?
    ) : QueryFragment.Droid, QueryFragment.Droid.Droid, DroidFragment, QueryFragmentImpl.Droid,
        Droid {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Droid.DroidDroid.toResponse(writer, this)
        }
      }
    }

    /**
     * An autonomous mechanical character in the Star Wars universe
     */
    data class OtherDroid(
      override val __typename: String = "Droid"
    ) : QueryFragment.Droid, QueryFragmentImpl.Droid {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Droid.OtherDroid.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun QueryFragmentImpl.Droid.droidFragment(): DroidFragment? = this as? DroidFragment

      fun QueryFragmentImpl.Droid.asDroid(): Droid? = this as? Droid
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  interface Human : QueryFragment.Human {
    override val __typename: String

    override fun marshaller(): ResponseFieldMarshaller

    /**
     * A humanoid creature from the Star Wars universe
     */
    interface Human : QueryFragment.Human, QueryFragment.Human.Human, QueryFragmentImpl.Human {
      override val __typename: String

      /**
       * What this human calls themselves
       */
      override val name: String

      /**
       * The home planet of the human, or null if unknown
       */
      override val homePlanet: String?

      override fun marshaller(): ResponseFieldMarshaller
    }

    /**
     * A humanoid creature from the Star Wars universe
     */
    data class HumanHuman(
      override val __typename: String = "Human",
      /**
       * What this human calls themselves
       */
      override val name: String,
      /**
       * The home planet of the human, or null if unknown
       */
      override val homePlanet: String?
    ) : QueryFragment.Human, QueryFragment.Human.Human, QueryFragmentImpl.Human, Human {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Human.HumanHuman.toResponse(writer, this)
        }
      }
    }

    /**
     * A humanoid creature from the Star Wars universe
     */
    data class OtherHuman(
      override val __typename: String = "Human"
    ) : QueryFragment.Human, QueryFragmentImpl.Human {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          QueryFragmentImpl_ResponseAdapter.Human.OtherHuman.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun QueryFragmentImpl.Human.asHuman(): Human? = this as? Human
    }
  }
}
