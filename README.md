# simple-tic-tac-toe

	To run tictactoe.jar:

	LINUX:
		1. Open terminal
		2. Enter the following:
			$ curl -s https://get.sdkman.io | bash
			$ bash
			$ sdk list kotlin
				(take note of the latest version in list and press "Q" to quit)
				(Alternatively, go to https://kotlinlang.org/docs/releases.html#release-details to get the latest FEATURE release version. Not BUG FIX release.)
			$ sdk install <latest kotlin version>
			$ java -jar tictactoe.jar

		MAC:
		[Homebrew is required]
			1. Open terminal
			2. Find the latest version of kotlin at https://kotlinlang.org/docs/releases.html#release-details
				NOTE: The lasest FEATURE RELEASE, not BUG FIX RELEASE
			2. Enter the following:
				$ brew update
				$ brew install <latest kotlin version>
				$ java -jar tictactoe.jar
