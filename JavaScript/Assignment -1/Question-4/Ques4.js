function countDown()
{
    var birthday = new Date("Oct 21, 2020 00:00:00").getTime();
    
    var now = new Date().getTime();    
    var t = Math.floor((birthday - now)/1000);
      
    var weeks = Math.floor(t / (60 * 60 * 24 * 7));
    var days = Math.floor(t % (60 * 60 * 24 * 7) / (60 * 60 * 24)); 
    var hours = Math.floor((t % (60 * 60 * 24)) / (60 * 60)); 
    var minutes = Math.floor((t % (60 * 60)) / 60); 
    var seconds = Math.floor(t / 60); 

    console.log("There are "+ weeks + " weaks, " +days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds until my next birthday!");
}

countDown();