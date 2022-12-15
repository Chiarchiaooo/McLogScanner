[licenseImg]: https://img.shields.io/badge/License-MIT-blueviolet
[license]: https://github.com/Chiarchiaooo/McLogScanner/blob/master/LICENSE
[mcversionImg]: https://img.shields.io/badge/Language-Java-orange
[mcversion]: https://tinyurl.com/5c56mn7r
[releaseImg]: https://img.shields.io/badge/Version-1.0-blue
[release]: https://github.com/Chiarchiaooo/McLogScanner/releases/latest

# McLogScanner
App made to make reading mc log files easier<br>
<br>

[![releaseImg]][release] ![mcversionImg] [![licenseImg]][license]
<br><br>

### ⚠️App still in developement⚠️

<br>

## Support

There are 3 possible ways to recieve support:
* Open a <a href=https://github.com/Chiarchiaooo/McLogScanner/issues> issue </a>
* Joining my <a href=https://dsc.gg/cliffycommunity>discord</a> and going on the **help section** after verifying
* DM Me to **~Luke#7123** or <a href=https://telegram.me/Ciarcia>**@Ciarcia**</a>


## Features

* **Checks minecraft log files**: _Takes a log file as input and checks if one of the following elements are present:_
  * Errors
  * Warnings
  * Chat messages
  * Commands
  * Player joins / disconnects
  * Plugins / custom messages

* **Separated ouput files**: _Each filter saves in his own separated file the `./output/<file name>/` directory_


* **Custom filters**: _The user can add custom filters using a `.yml file` to a specific run by using the `--custom-filters <path>` parameter

<br>

## How to Run

| Command                                 |
|-----------------------------------------|
| java -jar mcLogScanner.jar --parameters | 

## Parameters

You can add one or all of the elements from the following table to customize a specific run


| Parameter                                           | Description                                                                                                  |
|-----------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| --inputfile \<name/path>                            | **REQUIRED:** Specifies what file to scan                                                                    | 
| --inputdir \<name/path> \<mode> \<include-archives> | **alternative to** `--inputfile`, will scan every `.log` file in the directory                               |
| --outputdir \<path>                                 | Specifies where to create the output directory, if no directory is specified, the jar directory will be used |
| --custom-filters \<path>                            | Reload Plugin configs                                                                                        |

<br>

#### --inputdir \<name/path> \<mode> \<true/false>:
  - **<name/path>**: The name or the path to the file to the .log file


  - **\<mode>**: The operation mode
    - COMBINE: Combine all results into 1 file
    - SEPARATED: Default


  - **<include-archives>**: Wether or not scan .log files in compressed archives

## Donations

If you like my content and you want to support what I do, consider donating to <a href='https://ko-fi.com/U7U59S2LZ'>my ko-fi page</a>. <br>
#### Thank you❤️
[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/U7U59S2LZ)


## Rating

You can also check out the app on <a href=https://tinyurl.com/5c56mn7r>spigotmc.org</a><br><br>