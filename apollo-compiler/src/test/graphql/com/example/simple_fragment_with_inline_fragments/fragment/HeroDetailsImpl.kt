// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment_with_inline_fragments.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.example.simple_fragment_with_inline_fragments.fragment.adapter.HeroDetailsImpl_ResponseAdapter
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * A character from the Star Wars universe
 */
data class HeroDetailsImpl(
  override val __typename: String = "Character",
  /**
   * The name of the character
   */
  override val name: String,
  /**
   * The friends of the character, or an empty list if they have none
   */
  override val friends: List<Friend?>?
) : HeroDetail, GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller {
    return ResponseFieldMarshaller { writer ->
      HeroDetailsImpl_ResponseAdapter.toResponse(writer, this)
    }
  }

  /**
   * A character from the Star Wars universe
   */
  interface Friend : HeroDetail.Friend {
    override val __typename: String

    /**
     * The name of the character
     */
    override val name: String

    override fun marshaller(): ResponseFieldMarshaller

    /**
     * A humanoid creature from the Star Wars universe
     */
    interface Human : HeroDetail.Friend, HeroDetail.Friend.Human, Friend {
      override val __typename: String

      /**
       * The name of the character
       */
      override val name: String

      /**
       * Height in the preferred unit, default is meters
       */
      override val height: Double?

      override fun marshaller(): ResponseFieldMarshaller
    }

    /**
     * An autonomous mechanical character in the Star Wars universe
     */
    interface Droid : HeroDetail.Friend, HeroDetail.Friend.Droid, Friend {
      override val __typename: String

      /**
       * The name of the character
       */
      override val name: String

      /**
       * This droid's primary function
       */
      override val primaryFunction: String?

      override fun marshaller(): ResponseFieldMarshaller
    }

    /**
     * A humanoid creature from the Star Wars universe
     */
    data class HumanFriend(
      override val __typename: String = "Human",
      /**
       * The name of the character
       */
      override val name: String,
      /**
       * Height in the preferred unit, default is meters
       */
      override val height: Double?
    ) : HeroDetail.Friend, HeroDetail.Friend.Human, Friend, Human {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.Friend.HumanFriend.toResponse(writer, this)
        }
      }
    }

    /**
     * An autonomous mechanical character in the Star Wars universe
     */
    data class DroidFriend(
      override val __typename: String = "Droid",
      /**
       * The name of the character
       */
      override val name: String,
      /**
       * This droid's primary function
       */
      override val primaryFunction: String?
    ) : HeroDetail.Friend, HeroDetail.Friend.Droid, Friend, Droid {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.Friend.DroidFriend.toResponse(writer, this)
        }
      }
    }

    /**
     * A character from the Star Wars universe
     */
    data class OtherFriend(
      override val __typename: String = "Character",
      /**
       * The name of the character
       */
      override val name: String
    ) : HeroDetail.Friend, Friend {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          HeroDetailsImpl_ResponseAdapter.Friend.OtherFriend.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun Friend.asHuman(): Human? = this as? Human

      fun Friend.asDroid(): Droid? = this as? Droid
    }
  }
}
