## TODO LIST APPLICATION (ToDoLy)

Individual Project SDA

To-Do List Application which allows the user to add/edit/mark as done/remove tasks and display a list of these tasks sorted by either due date or project. Task list can be loaded from and saved into a text file.

# Manual

When starting the program, a user menu is displayed showing the amount of completed and incomplete tasks, as well as the possible different actions. Menu will keep being displayed after each action until user decides to quit the application.

** (1) Show Task List (By Due Date or Project)**

When selecting this option, user will be prompted to enter a valid sorting method for the task list. To sort the list by due date (earliest due date first) enter Due Date. To sort the list by project (alphabetical order) enter Project. Any other input will result in an error message and send the user back to the menu. Details shown in the list will be: Task title, due date, project and status (completed or not).

** (2) Add New Task**

Lets the user add a new task to the list. Program will ask for task details (title, due date and project). New added tasks will be automatically set to not completed. If the entered task title already exists on the list, an error is shown and the user is sent back to the menu.

** (3) Edit Task (Update, Mark As Done, Remove)**

Lets the user edit a specific task on the list. First, user will be asked to enter edit operation (enter Update, Mark As Done or Remove). Then the user is asked to enter the title of the task on which to perform the operation. In case of update, user is then asked to enter new task details (error is shown if new task title already exists somewhere else on the list). In case of mark as done or remove, selected task will be marked as completed or removed from the list.

** (4) Save and Quit**

Saves the latest state of the list into a file called list.txt located in the root folder of the project, and then quits the application. Next time the application is started, information from the list.txt file will be automatically loaded and imported into the program.