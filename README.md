# ReservationProject

Hello reviewers!  Here I'll give a quick overview of the completed project and choices made along the way.

First, I elected to use Java.  While I've worked professionally with C#/.NET and would have been comfortable doing the bulk of this project in that language, I haven't previously done the initial application setup to enable REST endpoints, etc.  Whereas, I've done this many times in Java and can have a new app up and running in a few minutes.  So, for this reason, I selected Java.

The app is functional and provides a number of APIs:
1) Get all providers
2) Get all appointment slots for a provider
3) Add appointment slots for a provider (rather than accepting which hours a provider will work, this accepts a list of appointment slots which they're working - and I assume those slots will be top of the hour, fifteen minutes into the hour, etc, rather than "odd" times.  Depending on the desired UX and functionality, this approach may make the frontend easier to develop, or possibly harder.  So, this is an area where I'd typically seek further feedback before proceeding - but, this approach seemed reasonable to me for the time being)
4) Get all "available" appointment slots for a provider
5) Reserve an appointment slot (with the requested validation to ensure at least twenty-four-hour notice)
6) Confirm an appointment slot
Also, a batch job is included to free up those reservations that weren't properly confirmed.  I intended to set this batch job to run every minute (and added comments saying such) but it appears that while doing some verification, I set it to execute every ten seconds and then I forgot to set it back.  Oops.

I'm definitely not a REST purist and I've taken some liberties in that regard.  The "GETS" _mostly_ follow REST conventions but the data updates generally don't.  For example, to book a reservation, I used "POST" with path "/appointmentSlots/{appointmentId}/reserve".  Personally, I find action-based paths easier to understand and it's my general preference - but also not something that's a huge deal for me if the company standards are different.

This was a quick project, so several corners were cut.  I made note of a number of items via "todo" comments but will call out a few here as well.  Foremost, the repository classes don't interact with an actual DB and instead store information in memory.  These repositories also include some initial seed data which was useful while testing.  I also would have taken another pass over the APIs - in particular, I don't like the structure of the API to add appointment slots for a provider - it takes in a list of dates, but I think it'd be clearer and more easily expandable if it took in a collection of objects (which could include the date, as well as other fields if needed).

Here are a couple of videos with additional information that may be useful: \
Demo: https://www.loom.com/share/48f49223faae4e7f859093c9d7a13bb7 \
Quick code walkthrough: https://www.loom.com/share/2ba114f611514dad95844c499d44604f
