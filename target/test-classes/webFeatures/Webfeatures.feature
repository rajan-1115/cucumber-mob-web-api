Feature: Verify jqueryui website

Scenario: Case1
Given User is on jqueryui website homepage with title "jQuery UI"
When User Select option Droppable from left menu under Interactions
And User Drag Drag me to my target component to Drop here component
Then Verify first component is dragged to second component




