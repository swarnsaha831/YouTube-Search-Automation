Feature: YouTube Search

	Scenario: Successful YouTube Search
		Given User opens chrome
		And User is redirected to YouTube
		When User enters the search in the search bar
		And User clicks the search button
		Then User is directed to all videos