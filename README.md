# BoilerPlan

## Goal

Students have trouble keeping track of assignments and deadlines from different
classes even with Brightspace. BoilerPlan is a study planner that makes it easier
to see upcoming assignments and stay organized.

## MVP

The first version should let me:
- add and view assignments
- sort assignments by due date
- mark assignments as done
- save and load assignments from a CSV file
- import assignments from a Brightspace calendar export

## Future plans (Schedule quadrant)

Things I'd like to add later, after the MVP works:

- automatically refresh Brightspace assignments
- sync with Google or Outlook Calendar
- use AI to find assignments in a syllabus
- make a calendar subscription link

## Tech stack

- Java 27
- CSV file for storage
- iCal4j and HttpClient for the Brightspace import (later)
- java.time for dates
