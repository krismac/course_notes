# Agile and Scrum

### Learning Objectives

- Know what Agile is and how Scrum implements it
- Understand the benefits of Agile and Scrum in web/software development
- Know the roles that make up Scrum teams

## Introduction

When developing software there are often many constraints involved, such as user requirements, deadlines and budgets. When working as a team to deliver a project, it is important to agree on the type of project management strategy being used. Each member of the team must be clear on their role and responsibilities to ensure the final project meets the requirements and is delivered on time and within budget.

Agile is a popular methodology used in software development and has been developed in response to some of the problems that arise from other project management processes. This lesson is going to cover Scrum, which is an implementation of Agile, and the benefits of using its practices when developing software in teams.

We will start by looking at another project management methodology, Waterfall, which produces some of the problems that Agile aims to solve.

## The Waterfall Methodology

The Waterfall method takes a linear approach to software development. In this methodology, the sequence of events could happen in the following order:

1. Gather and document requirements
2. Design
3. Build with unit and integration testing
4. Perform system testing
5. Perform user acceptance testing (UAT)
6. Fix any issues
7. Deliver the finished product

### Drawbacks of Waterfall

Gathering and documenting requirements in a way that is meaningful to a customer is often the most difficult part of software development; clients may not be completely sure what they need, or their requirements might not be documented accurately.

With Waterfall, the full product is built inline with the set of user requirements gathered from the customer at the start of the process. However, as the user's requirements might change in the time it takes to build the product, or they might look at the final product and feel that it is not representative of what was initially discussed, this process can lead to large losses in time. Making changes to the product once it has been fully built can be difficult and in the worst case, it can lead to the whole product being scrapped and the process started again from the beginning.

It was realised that it would be better to catch the inaccuracies of requirements and any required changes earlier in the development process.

## Agile

The Agile Method is an approach to project management that aims to respond to the unpredictability of developing software products, by focussing on incremental releases with frequent feedback cycles.

The [Manifesto for Agile Software Development](http://agilemanifesto.org/) written in 2001 states that agile software development aims for:

- Individuals and interactions over processes and tools
- Working software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan

## Scrum

Scrum is an implementation of agile and is one of agile's most popular frameworks, defining a set of practices that enable the above aims.

With scrum, the product is built in a series of fixed-length iterations called Sprints that give teams a framework for shipping software on a regular basis. Milestones (the end of a sprint) come frequently bringing with them a feeling of tangible progress with each cycle that focuses and energises everyone. Short iterations also reinforce the importance of good estimation and fast feedback from tests and the client – both recurring struggles in waterfall projects.

Scrum done well can massively improve team productivity and morale, and the product development process as a whole.

### Scrum Team

A Scrum team has a minimum of three specific roles:

#### 1. The Product Owner

Product owners are the champions for their product. They are focused on understanding business and market requirements, and prioritising the work to be done by the engineering team accordingly. Effective product owners:

- closely partner with the business and the team to ensure everyone understands the work items in the product backlog.
- give the team clear guidance on which features to deliver next.
- decide when to ship the product with the predisposition towards more frequent delivery.
- keep in mind that a product owner is not a project manager.

Product owners do not manage the status of the program. They focus on ensuring the development team delivers the most value to the business. Also, it's important that the product owner is an individual. No development team wants mixed guidance from multiple product owners.

#### 2. Scrum Master

Scrum masters are the champions for scrum within their team. This could be a job role in itself, or the product owner or a developer may take this role. The scrum master coaches the team, the product owner, and the business on the scrum process and look for ways to improve their practice of it. An effective scrum master deeply understands the work being done by the team and can help the team optimise their delivery flow. As the facilitator-in-chief, they schedule the needed resources (both human and logistical) for sprint planning, stand-up, sprint review, and the sprint retrospective.

Scrum masters also look to resolve impediments and distractions for the development team, insulating them from external disruptions whenever possible. Part of the scrum master's job is to defend against an anti-pattern common among teams new to scrum: changing the sprint's scope after it has already begun. Product owners will sometimes ask, "Can't we get this one more super-important little thing into this sprint?", but keeping scope air tight reinforces good estimation and product planning–not to mention fends off a source of disruption to the development team.

#### 3. Development Team (Developers, Testers, Designers, UX, etc.)

The development team drives the plan for each sprint. They forecast how much work they believe they can complete over the iteration using their experience as a guide.

Members of the development team are the champions for sustainable development practices. The most effective scrum teams are tight-knit, co-located, and usually 5 to 7 members. Team members have differing skill sets, and cross-train each other so no one person becomes a bottleneck in the delivery of work. Strong scrum teams approach their project with a clear "we" attitude. All members of the team help one another to ensure a successful sprint completion. The team might include testers, designers, and ops engineers in addition to developers.

A scrum team controls its own workflow and self-organises around their defined tasks. Agile teams use pull models where team member's pulls a certain amount of work off the backlog and commits to completing it that sprint, which is very effective in maintaining quality and ensuring optimum performance of the team over the long-term. Neither scrum masters nor product owners push work to the team (which, by contrast, tends to erode both quality and morale).

### Sprints

Scrum calls for four ceremonies that bring structure to each sprint:

#### 1. Sprint Planning

A team planning meeting that determines what to complete in the coming sprint.

**Requires**: Development Team, Scrum Master
**Optional**: Product Owner
**When**: At the start of a sprint.
**Purpose**: The Sprint Planning meeting is where the team defines the the work that will be completed in the sprint . Depending on the process being used by the Scrum team, user stories and a backlog are created, which structure the workflow for the entire sprint. A popular system for managing the sprint workflow is the Kanban board (see section 'Sprint Planning: Kanban Board'). The Sprint Planning meeting is where the Kanban board would be created.

#### 2. Daily Stand-up

Daily stand-up (also known as a daily scrum) is a 15 minute mini-meeting for the development team to synchronise.

- **Requires**: Development Team, Scrum Master
- **When**: Once per day
- **Purpose**: Stand-up is designed to quickly inform everyone of what's going on across the team. It's not a detailed status meeting. Each team member answers the following questions:
  1. What work did I complete yesterday?
  2. What will I work on today?
  3. Am I blocked by anything?

#### 3. Iteration Review

Work completed during the sprint is demonstrated and feedback is gathered.

- **Required**: Development Team, Scrum Master, Product Owner
- **Optional**: Project stakeholders
- **When**: At the end of a sprint
- **Purpose**: Iteration review is a time to showcase the work of the team. They can be in a casual format like "demo Fridays", or in a more formal meeting structure. This is the time for the team to celebrate their accomplishments, demonstrate work finished within the iteration, and get immediate feedback from project stakeholders. Remember, work should be fully demonstrable and meet the team's quality bar to be considered complete and ready to showcase in the review. Incremental feedback gathered from stakeholders at each demo ensures the product is meeting requirements throughout the development process.

#### 4. Retrospective

A meeting where the sprint is evaluated.

- **Required**: Development Team, Scrum Master, Product Owner
- **When**: At the end of the sprint
- **Purpose**: Agile is about getting rapid feedback to make the product and development culture better. Retrospectives help the team understand what worked well–and what didn't and is the opportunity to identify actions to make the next sprint better.

### Sprint Planning: Kanban Board

Sprints will often implement a system for defining tasks and keeping track of who is doing what. Scrum encourages using a pull model, where team members assign themselves to the approriate tasks, rather than tasks being delegated by a project manager. The Kanban board is a popular example of such a system where tasks are defined in a backlog, and moved from 'doing' to 'done' as they get completed. As a team member takes a task from the backlog, they can assign themselves to it, so everyone can see who is working on what.

A Kanban board is developed and used in the following way:

- The product owner creates a list of user stories for the sprint. A story or user story is the smallest unit of work in an agile framework. It is a software system requirement that is expressed in a few short sentences, ideally using non-technical language. For example: "A user can input departure and return dates and view a list of available flights".
- The full Scrum team collectively decide how the divide these user stories into tasks. These are the granular pieces of work that help define the implementation items for the story and the upcoming sprint.
- The backlog is created. A product backlog is a prioritised list of work for the development team that is derived from the roadmap and its requirements. All work items should be included in the backlog: user stories, bugs, design changes, technical debt, customer requests, action items from any previous retrospective.

The Kanban board can be a powerful motivators. They drive a spirit of "we're doing this!". They also allow the development team to self-organise the division of tasks, as team members can take tasks of the backlog themselves, replacing the more traditional project manager role.

## Conclusion

The Agile methodology was developed to solve common problems that occur when developing software with other project management strategies. Agile aims are:

- Individuals and interactions over processes and tools
- Working software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan

Scrum is an implementation of Agile which provides a set of practices that enable the Scrum team to define, manage and track the product development process with short iterations of feature development and frequent feedback cycles.
