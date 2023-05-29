# PrettyLogger [![](https://jitpack.io/v/CesPaul/PrettyLogger.svg)](https://jitpack.io/#CesPaul/PrettyLogger)

PrettyLogger is a handy logger for Okhttp and Ktor.

<details> 
  <summary>Screenshot </summary>
   <img src="https://github.com/CesPaul/PrettyLogger/assets/43243212/750c14b8-59af-44dd-806d-3acf5eaf5644" style="width: auto; height: 300px">
</details>



## How to add
Add the following dependency to get a library into your build:

#### Okhttp:
	implementation 'com.github.CesPaul.PrettyLogger:okhttp:0.1.3'
	
or

	implementation("com.github.CesPaul.PrettyLogger:okhttp:0.1.3")
	
#### Ktor:
	implementation 'com.github.CesPaul.PrettyLogger:ktor:0.1.3'
	
or
	
	implementation("com.github.CesPaul.PrettyLogger:ktor:0.1.3")

## How to use
#### Okhttp:

    val prettyLogger by lazy {
        PrettyLogger {
            Log.d("TAG Okhttp", it)
        }
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(prettyLogger).setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()


#### Ktor:
	val client = HttpClient(Android) {
		    install(Logging) {
			level = LogLevel.ALL
			val prettyLogger = PrettyLogger { Log.d("TAG Ktor", it) }
			logger = prettyLogger
		    }
		}
