pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android Lessens"
include(":app")
include(":p0061_layouts")
include(":p0061_linearlayour")
include(":p0072_layouttema")
include(":p0081_viewbyld")
include(":P0101_listener")
include(":p0211_twoactivity")
include(":p0241_twoactivitystate")
include(":p0261_intentfilter")
include(":p0271_getintentaction")
include(":p0281_intentextras")
include(":p0291_simpleactivityresult")
include(":p0301_activityresult")
include(":p0311_simpleintents")
include(":mvideo")
include(":p0321_simplebrowser")
include(":p0331_sharedpreferences")
include(":p0341_simplesqlite")
include(":p0361_sqlitequery")
include(":p0371_sqliteinnerjoin")
include(":p0372_sqliteinnerjoinn")
include(":p0381_sqlitetransaction")
include(":p0401_layoutinflater")
include(":p0411_layoutinflaterlist")
include(":p0421_simplelist")
include(":p0421_simplelist")
include(":p0431_simplelistchoice")
include(":p0441_simplelistevents")
include(":p0451_expandablelist")
include(":p0461_expandablelistevents")
include(":p0471_recycleview")
