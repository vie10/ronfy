# Ronfy — simple runtime config container

Provides ability to storage your configurations in runtime easy and beautiful. Also makes config reloading simple.

### Example

```kotlin
class MyApplication : Application {

    override fun onReloadConfig() {
        loadConfig().uploadToRonfy()
    }
}

class Notifier {

    // Look at this. It's a variable with custom getter. Avoid storing the config in variable.
    private val config: Config get() = Config::class.loadFromRonfy()

    fun notify(text: String) {
        val formattedText = config.notifierFormat!!.format(text)
    }
}
```
