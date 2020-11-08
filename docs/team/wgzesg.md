# Zesong - Project Portfolio Page

## PROJECT: The Schwarzenegger 

### Overview
The Schwarzenegger is a desktop command line interface-based app for managing all your needs regarding fitness. With the built-in personal assistant, you are able to track your daily workout and diet sessions based on your profile. If you can type fast, The Schwarzenegger can help you maximise your efficiency for maintaining fitness.

### Summary of Contributions
**Major Enhancement**: Implemented feature to allow events to repeat.
- What it does: 
  - It allows users to set an event to repeat for any period so that they do not have to add tasks with the same/similar name but
    different timing for every instance the user wants the task to repeat for.

- Justification:
  - Improves usability and user experience of the app as repeating events are relatively common and having to add multiple tasks to keep
   track of a repeating event will become a hassle. 
  - Providing flexibility to allow user to repeat for any period will be useful for modules that do not have weekly classes (every 2/3
   weeks) 

- Highlights: 
  - Repeating an event was particularly difficult and tedious to implement due to the many ways one can implement it (with different pros
   and cons). This led to many changes in its implementation over the weeks as we try to cater to different needs that we have identified for 
   our target audience - students. To list a few:
    - There was initially difference in implementation for `Calendar` feature which interacts with `Repeat` feature but was not caught
    until both developers finished and did their pull requests which led to more changes in implementation.
    - We also later discovered a particular 'bug' with `LocalDateTime` API from Java relating to the last few dates of a month. Adding 1
    month to 31 Jan 2020 then adding another, will result in 29 Mar 2020 instead of the desired 31 Mar 2020. This led to another round of
    changes to how repeat event was implemented.  
  - This enhancement was difficult to implement as it was my first time handling with Date and Time, particularly `LocalDateTime` API and
   its variations in Java and was not used to the many corner cases. I had to plan properly and take note of the many corner cases before
   obtaining the current implementation. 
   (Credit to team for helping me catch bugs relating to my first few implementations and providing feedback on how to improve.)

**Minor Enhancement**: 
- Implemented `list` commands for `list`(listing all tasks), `list incomplete assignments`, `list upcoming events`.
- Implemented `CommandResult` class to deal with output from commands.
- Added `common/Messages` to store all the strings that are used for printing to user. [#38](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/38)
- Refactored `common/Messages` to remove repetitive strings that have similar messages. [#94](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/94)

**Code Contributed:** [View on RepoSense](https://nus-cs2113-ay1920s2.github.io/tp-dashboard/#breakdown=true&search=e0309556&sort=groupTitle&sortWithin=title&since=2020-03-01&timeframe=commit&mergegroup=false&groupSelect=groupByRepos&tabOpen=true&tabType=authorship&tabAuthor=e0309556&tabRepo=AY1920S2-CS2113T-M16-1%2Ftp%5Bmaster%5D)


**Contributions to the User Guide:**
- Add instructions for `RepeatCommand`. 
- Add tips and notes for understanding our command format. [#104](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/104/files)
- Fix inconsistencies in formatting and broken links during conversion to md from adoc. [#150](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/150)

**Contributions to the Developer Guide:**
- Add Section 3.4: Repeat Event feature
- Add initial information to Appendix A (Product Scope) and D (Non-Functional Requirements) that are subsequently improved by team. [#135](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/135)
- Improved Section 4: Testing draft written by team.

**Contributions to Team-based Tasks:**
- Set up Github Repo for ATAS 
- Managed Issue Tracker in Github
- Enable Assertion for Gradle

**Community**:
- Refactored and enhanced `Help` command implementation [#92](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/92)
- Fix inconsistencies in formatting and broken links prior to and after CS2101 UG Feedback session and CS2113T Practical Examination Dry Run. [#200](https://github.com/AY1920S2-CS2113T-M16-1/tp/pull/200)