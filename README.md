### Installation

1. Download http://apt.typesafe.com/typesafe-stack-2.0.1.exe
2. Install
3. Open console
4. Type ```sbt sbt-version``` and wait for it to complete
5. Download http://git-scm.com/download/win
6. Follow http://help.github.com/win-set-up-git/ but select `Run Git from Windows Command Prompt`
7. Create an account on http://www.github.com

### Project Initialisation

1. Open console
2. Change directory to wherever you want to have the project directory
3. Run `git clone git://github.com/akuendig/webshop.git`
4. Conratulations, you have now the newest version of the project
5. `cd` into the project directory
6. Run `sbt`
7. Run `eclipsify`
8. Import the project into eclipse
9. Start MySql Server
10. Back in console run `play run`
11. Open http://localhost:9000

### Debugging

To be able to debug with eclipse you need to add the following Environment Variable:
*SBT_OPTS* with the value `-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9999`
after that the command `sbt` will automatically open a debug port at `localhost:9999`.
Now go into eclipse

1. Choose the webshop project
2. Click *DebugAs*
3. Select *Remote Java Application* and enter `9999` as the port, choose a sutable name
4. Click *Apply* and the *Debug*
5. Now you should be able to set breakpoints and all inside eclipse

### Old Info from Playframework

* install sbt 0.11.2  if you do not have it already. You can get it from here: https://github.com/harrah/xsbt/wiki/Getting-Started-Setup

* execute 'sbt' and then `help play` for play specific commands

* execute `sbt` and then `compile` to build the project

* execute `sbt` and then 'run' to run the built-in development server

* once the development server is running, documentation is available at http://localhost:9000/@documentation



