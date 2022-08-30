Feature: Reset Login Credentials
Scenario Outline: Verify Reset Button with number of Credentials
Given Open the Chrome and Launch the application
When Enter Username "<UserName>" and Password "<Password>"
Then Reset the credentials

Examples:
|UserName |Password  |

|User1    |Test1		 |  

|User2    |Test2		 |  

|User3    |Test3		 |  

|User4    |Test4		 |  

|User5    |Test5		 |  