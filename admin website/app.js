const users = document.querySelector('#users-list')
const form = document.querySelector('#add-user-form')


// create element and render users
function renderUsers(doc) {
    let li = document.createElement('li');
    let bus_no = document.createElement('span');
    let child_name = document.createElement('span');
    let classname = document.createElement('span');
    let drivername = document.createElement('span');
    let email = document.createElement('span');
    let full_name = document.createElement('span');
    let mobile = document.createElement('span');
    let password = document.createElement('span');
    let pic = document.createElement('span');
    let round = document.createElement('span');
    let school = document.createElement('span');
    let username = document.createElement('span');
    let cross = document.createElement('div');


    li.setAttribute('data-id' , doc.id);
    bus_no.textContent = doc.data().bus_no;
    child_name.textContent = doc.data().child_name;
    classname.textContent = doc.data().classname;
    drivername.textContent = doc.data().drivername;
    email.textContent = doc.data().email;
    full_name.textContent = doc.data().full_name;
    mobile.textContent = doc.data().mobile;
    password.textContent = doc.data().password;
    pic.textContent = doc.data().pic;
    round.textContent = doc.data().round;
    school.textContent = doc.data().school;
    username.textContent = doc.data().username;
    cross.textContent = 'x';
    

    li.appendChild(bus_no);
    li.appendChild(child_name);
    li.appendChild(classname);
    li.appendChild(drivername);
    li.appendChild(email);
    li.appendChild(full_name);
    li.appendChild(mobile);
    li.appendChild(password);
    li.appendChild(pic);
    li.appendChild(round);
    li.appendChild(school);
    li.appendChild(username);
    li.appendChild(cross);


    users.appendChild(li);

//delete data
    cross.addEventListener('click', (e) => {
    e.stopPropagation();
    let id = e.target.parentElement.getAttribute('data-id');
    db.collection('users').doc(id).delete();
    })

}
// getting data

db.collection('users').get().then((snapshot) =>{
    snapshot.docs.forEach(doc => {
        renderUsers(doc);

    })
})


// saving data

form.addEventListener('submit', (e) =>{
    e.preventDefault();
  //  if (typeof child_name != "form.child_name.value") {
        
     
    db.collection('users').add({
        bus_no: form.bus_no.value,
        child_name: form.child_name.value,
        classname: form.classname.value,
        drivername: form.drivername.value,
        email: form.email.value,
        full_name: form.full_name.value,
        mobile: form.mobile.value,
        password: form.password.value,
        pic: form.pic.value,
        round: form.round.value,
        school: form.school.value,
        username: form.username.value
    });
    form.bus_no.value = '';
    form.child_name.value = '';
    form.classname.value = '';
    form.drivername.value = '';
    form.email.value = '';
    form.full_name.value = '';
    form.mobile.value = '';
    form.password.value = '';
    form.pic.value = '';
    form.round.value = '';
    form.school.value = '';
    form.username.value = '';

})