package com.sapient.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages({"com.sapient.dao","com.sapient.models"})

@IncludeTags("dev")
@Suite
public class GlobalInsTestSuite {
}
