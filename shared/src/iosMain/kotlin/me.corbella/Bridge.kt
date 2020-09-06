package me.corbella

import cc.popkorn.InjectorObjC
import cc.popkorn.core.Injector
import cc.popkorn.mapping.Mapping
import cc.popkorn.pools.MappingProviderPool
import cc.popkorn.pools.MappingResolverPool
import cc.popkorn.popKorn
import kotlinx.cinterop.ObjCClass
import platform.Foundation.NSLog


//Expose the PopKorn setup function to be called from ObjectiveC as ObjectiveC won't have direct access to the library methods
fun init(creator:(ObjCClass)-> Mapping) = cc.popkorn.setup(creator)

//Gets PopKorn injector to be used in ObjectiveC classes. This does not create a new injector, but wraps the default one
fun getInjector() = InjectorObjC(popKorn())