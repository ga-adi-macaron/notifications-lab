---
title: Notifications
type: lab
duration: "1:25"
creator:
    name: Yuliya Kaleda
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Notifications

## Introduction

> ***Note:*** _This lab should be done in pairs._

In this lab, you will work with a partner to build a network notification app. The idea behind the app is to give the user information about connectivity state when the app gets opened.

When the app is launched, there should be an expanded notification with a large image informing the user about network connectivity. When the notification is clicked, the user should be redirected to another activity. If network is available,
the notification should be dismissed in the second activity. If network is not available, the notification icon should remain in the status bar.

Your app doesn't need to look like the screenshot in the deliverable section below, but it needs to have the same functionality.

## Exercise

#### Requirements

The app should have 2 activities:  

- **Main Activity** that handles notification objects;  
- **Second Activity** that is responsible for dismissing the notification if it shows that the network connection is available

Your app should check network connection:

* When available:

  * show a notification with the an image (feel free to choose any image that will be associated with network connectivity)
  * redirect the user to a new activity when the notification is clicked
  * dismiss the notification in the new activity

* When unavailable:

  * show a notification with an image (feel free to choose any image that will be associated with network connectivity absence)
  * redirect the user to a new activity when the notification is clicked
  * make sure the notification icon does not go away unless the user swipes the notification away

**Bonus**

- Create another notification that has a "call" button; when the user presses the button, the phone dials any number

#### Deliverable

Here are two screenshots of the requirements:

<p align="center">

  <img src="./screenshots/no_network.png" width="320" height="420">

  <img src="./screenshots/Screen Shot 2016-01-21 at 12.29.01 PM.png" width="320">

</p>

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
