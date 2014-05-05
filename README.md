//upload entire folder or project onto git
cd "C:\Users\Jake\Google Drive\School\Extra\Programming\Web Development\iPoolsAZ.com\projects\project5"
touch README.md
git init
git add .
git commit -m "first commit"
git remote add origin https://github.com/doppl3r/iPoolsAZ.git
git push -u origin master

//get entire project from a github.com repository
cd "C:\Users\Jake\Google Drive\School\Extra\Programming\Web Development\iPoolsAZ.com\main"
git init
git remote add origin https://github.com/kud0h/iPoolsAZ
git pull -u origin master

//clone from github
cd "C:\Users\Jake\Google Drive\School\Extra\Programming\Web Development\iPoolsAZ.com\main"
git clone https://github.com/kud0h/iPoolsAZ

//update a file(s)
cd "C:\Users\Jake\Google Drive\School\Extra\Programming\Web Development\iPoolsAZ.com\main\iPoolsAZ"
git add .
git commit -m "message"

//pull from other branch
git checkout --track origin/windows
git branch

//count number of lines
cd "C:\Users\doppler\IdeaProjects\Dark-Saunter\src"
git ls-files | xargs wc -l