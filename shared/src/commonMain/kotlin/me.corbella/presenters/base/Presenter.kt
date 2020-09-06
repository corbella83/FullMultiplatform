package me.corbella.presenters.base

import cc.popkorn.annotations.Exclude
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.corbella.BackgroundDispatcher
import me.corbella.MainDispatcher
import kotlin.jvm.Synchronized

@Exclude
abstract class Presenter<V : Contract.View, R : Contract.Router> {
    private val coroutineScope = CoroutineScope(SupervisorJob() + MainDispatcher)

    private var view: V? = null
    private var router: R? = null

    private val pendingViewTransactions = LinkedHashSet<V.() -> Unit>()
    private val pendingRouterTransactions = LinkedHashSet<R.() -> Unit>()


    //Force to implement this methods
    abstract fun initialize(args: Arguments)
    abstract fun destroy()

    //Optionally implement this methods
    protected open fun onViewAttached() {}
    protected open fun onViewDetached() {}
    protected open fun onRouterAttached() {}
    protected open fun onRouterDetached() {}


    @Synchronized
    fun attachView(view: V) {
        if (this.view === view) return
        this.view = view
        pendingViewTransactions.forEach { it.invoke(view) }
        onViewAttached()
    }


    @Synchronized
    fun detachView() {
        this.view = null
        onViewDetached()
    }


    @Synchronized
    protected fun draw(lambda: V.() -> Unit) {
        view?.apply(lambda) ?: pendingViewTransactions.add(lambda)
    }


    @Synchronized
    fun attachRouter(router: R) {
        if (this.router === router) return
        this.router = router
        pendingRouterTransactions.forEach { it.invoke(router) }
        onRouterAttached()
    }

    @Synchronized
    fun detachRouter() {
        router = null
        onRouterDetached()
    }

    @Synchronized
    protected fun navigate(lambda: R.() -> Unit) {
        router?.apply(lambda) ?: pendingRouterTransactions.add(lambda)
    }

    fun <T> launch(function: suspend () -> T, success: (T) -> Unit) {
        coroutineScope.launch {
            val result = withContext(BackgroundDispatcher) { function() }
            withContext(MainDispatcher) { success(result) }
        }
    }


}