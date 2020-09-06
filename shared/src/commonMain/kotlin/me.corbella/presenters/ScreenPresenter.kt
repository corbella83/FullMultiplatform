package me.corbella.presenters

import cc.popkorn.annotations.Injectable
import cc.popkorn.core.Scope
import me.corbella.presenters.base.Arguments
import me.corbella.presenters.base.Presenter
import me.corbella.repositories.model.EParam
import me.corbella.usecases.CountryUseCase
import me.corbella.usecases.IpUseCase
import me.corbella.usecases.LocationUseCase
import me.corbella.usecases.PlatformUseCase

@Injectable(Scope.BY_NEW)
class ScreenPresenter internal constructor(
    private val platformUseCase: PlatformUseCase,
    private val locationUseCase: LocationUseCase,
    private val ipUseCase: IpUseCase,
    private val countryUseCase: CountryUseCase
) : Presenter<ScreenContract.View, ScreenContract.Router>(), ScreenContract.Presenter {


    override fun initialize(args: Arguments) {
        draw { drawValue("Welcome") }
    }

    override fun destroy() {

    }


    override fun onParamClick(param: String) {
        val enumParam = EParam.fromString(param)

        launch(
            function = { getParam(enumParam) },
            success = { draw { drawValue(it) } }
        )
    }


    private suspend fun getParam(param: EParam): String {
        return when (param) {
            EParam.IP -> ipUseCase.execute()
            EParam.COUNTRY -> countryUseCase.execute()
            EParam.LOCATION -> locationUseCase.execute()
            EParam.PLATFORM -> platformUseCase.execute()
        }
    }

}