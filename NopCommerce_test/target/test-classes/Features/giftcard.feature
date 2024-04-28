Feature: GiftCards 

Background: 
	Given user Launch NopCommerce Website 
	
Scenario: Login To NopCommerce And Add New Gift Card 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Enters GiftCard Option 
	And user Clicks On Add Button 
	And user Enters Gift Card Details 
	Then user Gets "Gift Card Successfully Added Message" Msg 
	
Scenario: Activate Gift Card 
	When user Enters Email And Password 
	And user Click On LogIn 
	Then user Can View The Dashboard 
	When user Enters GiftCard Option 
	And user Activates Gift Card 
	Then user Gets "Gift Card has been updated Successfully" message