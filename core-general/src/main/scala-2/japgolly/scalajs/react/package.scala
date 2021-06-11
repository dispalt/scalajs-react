package japgolly.scalajs

import japgolly.scalajs.react.util.DefaultEffects.{Async => DefA, Sync => DefS}
import japgolly.scalajs.react.util.Effect.Id
import scala.scalajs.js

package object react extends ReactExtensions {
// package object react extends ReactEventTypes with ReactExtensions {

  type Key = facade.React.Key

  type StateAccessPure[S] = StateAccess[DefS, DefA, S]
  type StateAccessImpure[S] = StateAccess[Id, DefA, S]

  type SetStateFnPure[S] = SetStateFn[DefS, DefA, S]
  type SetStateFnImpure[S] = SetStateFn[Id, DefA, S]

  type ModStateFnPure[S] = ModStateFn[DefS, DefA, S]
  type ModStateFnImpure[S] = ModStateFn[Id, DefA, S]

  type ModStateWithPropsFnPure[P, S] = ModStateWithPropsFn[DefS, DefA, P, S]
  type ModStateWithPropsFnImpure[P, S] = ModStateWithPropsFn[Id, DefA, P, S]

  val GenericComponent = component.Generic
  type GenericComponent[P, CT[-p, +u] <: CtorType[p, u], U] = GenericComponent.ComponentSimple[P, CT, U]

  val JsComponent = component.Js
  type JsComponent[P <: js.Object, S <: js.Object, CT[-p, +u] <: CtorType[p, u]] = JsComponent.Component[P, S, CT]
  type JsComponentWithFacade[P <: js.Object, S <: js.Object, F <: js.Object, CT[-p, +u] <: CtorType[p, u]] = JsComponent.ComponentWithFacade[P, S, F, CT]

  val JsFnComponent = component.JsFn
  type JsFnComponent[P <: js.Object, CT[-p, +u] <: CtorType[p, u]] = JsFnComponent.Component[P, CT]

  // val JsForwardRefComponent = component.JsForwardRef
  // type JsForwardRefComponent[P <: js.Object, R, CT[-p, +u] <: CtorType[p, u]] = JsForwardRefComponent.Component[P, R, CT]

  type ScalaComponent[P, S, B, CT[-p, +u] <: CtorType[p, u]] = component.Scala.Component[P, S, B, CT]
  type BackendScope[P, S] = component.Scala.BackendScope[P, S]

  val ScalaFnComponent = component.ScalaFn
  type ScalaFnComponent[P, CT[-p, +u] <: CtorType[p, u]] = ScalaFnComponent.Component[P, CT]

  // val ScalaForwardRefComponent = component.ScalaForwardRef
  // type ScalaForwardRefComponent[P, R, CT[-p, +u] <: CtorType[p, u]] = ScalaForwardRefComponent.Component[P, R, CT]

  // type CustomHook[I, O] = hooks.CustomHook[I, O]
  // val CustomHook        = hooks.CustomHook
  // val Hooks             = hooks.Hooks
  // val HooksApi          = hooks.Api

  type ~=>[-A, +B] = Reusable[A => B]

  // val preventDefault: ReactEvent => Callback =
  //   _.preventDefaultCB

  // val stopPropagation: ReactEvent => Callback =
  //   _.stopPropagationCB

  // lazy val preventDefaultAndStopPropagation: ReactEvent => Callback =
  //   e => e.preventDefaultCB >> e.stopPropagationCB
}
