package io.kranberry.environment

object TestHandler {

    lateinit var currentTestMethodName: String
    lateinit var currentTestClassName: String
    var testClassName = ""

    var failedTestCount: Double = 0.0
    var passedTestCount: Double = 0.0
    var totalTestCount: Double = 0.0

    var reportHasHeader: Boolean = false


    fun testClassName(testClassName: String) {
        this.testClassName = testClassName
    }
}
