# Ronfy — simple runtime config container

[![](https://jitpack.io/v/vie10/ronfy.svg)](https://jitpack.io/#vie10/ronfy)

Provides ability to storage your configurations in runtime easy and beautiful. Also makes config reloading simple.

### Example

```kotlin
class MyApplication : Application {

    override fun onReloadConfig() {
        loadConfig().uploadToRonfy()
    }
}

class Notifier {

    // Look at this. It's a variable with custom getter. Ensure you're always using this way.
    private val config: Config get() = Config::class.loadFromRonfy()

    fun notify(text: String) {
        val formattedText = config.notifierFormat!!.format(text)
    }
}
```
