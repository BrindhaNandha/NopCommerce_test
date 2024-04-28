Feature: Customers 

Background: 
	Given user Launch NopCommerce Website 
		
Scenario: Login To NopCommerce And Add New Customer 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Click On Customers Menu 
	And user Clicks On Customers Option 
	Then user Can View  The Customer Page 
	When user Click on AddNew Button 
	And user Updates Customer Information 
	And user Clicks On Save Button 
	Then user Can View Success Message "The new customer has been added successfully." 
	
	
Scenario: Search Customer By Email 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Click On Customers Menu 
	And user Clicks On Customers Option 
	Then user Can View  The Customer Page 
	When user Enters The Email To Be Searched In Email Tab 
	And user Clicks On Search Button 
	Then user Should Find The Customer In The Customer Table 
	
Scenario: Search Customer By Name 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Click On Customers Menu 
	And user Clicks On Customers Option 
	Then user Can View  The Customer Page 
	When user Enters The ForeName To Be Searched In ForeName Tab 
	And user Clicks On Search Button 
	Then user Should Find The Customer In The Customer Table 
	
Scenario: Search Customer By Name And Delete The Record 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Click On Customers Menu 
	And user Clicks On Customers Option 
	Then user Can View  The Customer Page 
	When user Enters The ForeName To Be Searched In ForeName Tab 
	And user Clicks On Search Button 
	When user Selects the Searched Customer Record From Table 
	And user Clicks Edit Button 
	And user Clicks Delete Button 
	And user Confirms the Delate Prompt Message 
	Then user Can View Confirmation Message "The customer has been deleted successfully" 
	
	
	
	
	
	
	
	
	
	
