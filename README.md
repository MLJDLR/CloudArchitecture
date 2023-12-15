# Cloud Integration Project
Maxime LARROZE 'MLJDLR' <br>
Thomas MIRAS GARCIA 'Vamlack' <br> <br>
---

Table of Contents

[1. CRUD - Create](#create) <br>
[2. CRUD - Read](#read) <br>
[3. CRUD - Update](#update) <br>
[4. CRUD - Delete](#delete) <br>
[5. Docker - Image](#image) <br>

---
<div id='create'/>  
  
# 1. CRUD - Create

Here are our 5 students at the beginning :
![image](screens/c1.png) <br><br>

We create a new one (john doe, 25) :
![image](screens/c2.png) <br><br>

And here we can see the new student :
![image](screens/c3.png) <br><br>

---
<div id='read'/>
  
# 2. CRUD - Read

Here same as in the Postman app, we can see our 6 students :
![image](screens/r1.png) <br><br>

---
<div id='update'/>
  
# 3. CRUD - Update

We update student (id = 3) and we can see it was done :
![image](screens/u1.png) <br><br>

When we try to update on a non-existing student (id not in database), nothing happens :
![image](screens/u2.png) <br><br>

And we can see in our local server that student (id 3) has a new name & age, nothing happened for the update on student (id 8) because this id doesn’t exist :
![image](screens/u3.png) <br><br>

---
<div id='delete'/>
  
# 4. CRUD - Delete

Here we delete student named “Thomas”, we have confirmation (inputted in our code as such) :
![image](screens/d1.png) <br><br>

And when we try on a student not in the database we can see that it doesn’t work and it displays “student doesn’t exist” (same as before we inputted as such in our code)
![image](screens/d2.png) <br><br>

Finally, we can see by doing a get (here in local server but same in postman) that student Thomas was deleted and no issue occurred because Abi doesn’t exist as a student :
![image](screens/d3.png) <br><br>

---
<div id='image'/>
  
# 5. Docker - Image

Launch docker :
![image](screens/docker.png) <br><br>


