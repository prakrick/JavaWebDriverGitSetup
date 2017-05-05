package com.JavaWebDriverGit.TestScript;

import java.io.IOException;

import com.JavaWebDriverGit.InitialSetup.ReadConfig;

public class TestScripts {
	public static void main(String[] args) throws IOException {
		ReadConfig readConfigObj = new ReadConfig();
		readConfigObj.getPropValues();
		
	}

}
