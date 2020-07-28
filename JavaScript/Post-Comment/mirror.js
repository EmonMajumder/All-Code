$(function() {

    loadhomepage();

    fetch('http://localhost:3000/posts')
        .then(response=>response.json()
        .then(data=>{
            data.map(post=>{                
                addrow(post);
                
                $(`#td${post.id}`)
                .click(()=>{                    
                    showpost(post);
                    loadcomments(post);
                    $("#submit").click(() => {
                        submitcomment(post.id);                                                
                    });
                })
                .hover(function(){
                    $(this).css({'cursor': 'pointer'});
                    $(this).html(`<strong>${$(this).text()}</strong>`);
                },
                function(){
                    $(this).text(`${$(this).text()}`);
                });

                $(`#e${post.id}`)
                .click(()=>{                                       
                    $("#main").append(                        
                        `<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>`
                    )
                    $("#postorupdate").html(
                        `<button class="btn waves-light" name="submit" id="update">Update</button>`
                    )

                    $("#title").val(`${post.title}`);
                    $("#body").val(`${post.body}`);
                    
                    $("#update").click(() => {
                        const editedpost = makepost();  
                        if(editedpost)
                        {                            
                            handleconfirmation(post.id,editedpost);
                        }
                    });    
                })

                $(`#d${post.id}`)
                .click(()=>{
                    handleconfirmation(post.id);                    
                })
            });
            $("#wait").css("display", "none");        
        }))    

    $("#submit").click(()=>{
        const post = makepost();  
        if(post)
        {
            $("#wait").css("display", "block");

            fetch("http://localhost:3000/posts", {
                method: "POST",
                headers: {
                "Content-Type":"application/json"
                },
                body: JSON.stringify(post)      
            })
            .then(response => {
                if(response.ok){
                    let postId;
                    fetch('http://localhost:3000/posts')
                    .then(response=>response.json()
                    .then(data=>{
                        postId=data[data.length-1].id;
                        submitcomment(postId);                                
                    }))
                }
                else{
                    throw new Error("HTTP status " + response.status);
                }
            })
        }        
    });    

    $("#dialog").css("display","block");
    $("#dialog").dialog({
        dialogClass: "no-close",
        autoOpen: false,
        modal: true
    });

    $("button").mouseover(()=>{$( this ).css({'cursor': 'pointer'});});
})()

function loadhomepage(){
    $("#main").html(
        `<div class="row" style="width:80%;">

        <div class="input-field col s12">                                       
            <input id="title" name="title" type="text"/>   
            <label htmlFor="title">Title</label>
            <span id="titleerror" style="display:none;color:red">Title should have atleast 3 letters.</span>                     
        </div>              

        <div class="input-field col s12">
            <textarea id="body" class="materialize-textarea"></textarea>                    
            <label htmlFor="body">Post</label>
            <span id="bodyerror" style="display:none;color:red">Body should have atleast 3 words.</span>
        </div>

        <div class="input-field col s12">
            <input id="comment" name="comment" type="text"/>
            <label htmlFor="comment">Comment</label>
        </div>

        <div class="center-align" id="postorupdate">
            <button class="btn waves-light " id="submit">Post</button>
        </div>
        <br/>
        <div id="posttable" class="center-align" style="width:80%;margin:auto">
            <table class="highlight centered responsive-table">
                <thead>
                  <tr>
                      <th>Title</th>
                      <th>Body</th>
                      <th>Date</th>
                      <th>Action</th>
                  </tr>
                </thead>            
                <tbody>
                </tbody>
            </table>
        </div>
    </div>`
    )
}

function addrow(post){
    $("tbody").prepend(
        `<tr>                        
            <td id="td${post.id}" style="width:20%;">${post.title}</td>
            <td style="width:50%;">${post.body}</td>
            <td>${post.date}</td>
            <td>
                <button class="btn waves-light" id="e${post.id}">
                    <i class="small material-icons" >edit</i>
                </button>
                <button class="btn waves-light" id="d${post.id}">
                    <i class="small material-icons" >delete</i>
                </button>
            </td>
        </tr>`
    );
}

function showpost(post){
    $("#main").html(
        `<div class="row">                                         
        <div class="input-field col s12">                                                       
            <span id="title"><strong>Title : </strong>${post.title}</span>   
            <br>
            <div class="col s12" id="body">${post.body}</div>
        </div>                           
        </div>
        <br/>
        <div class=row>
            <div class="input-field col s10">
                <input id="comment" name="comment" type="text"/>
                <label htmlFor="comment">Comment</label>
            </div>
            <div class="center-align">
                <button class="btn waves-light" id="submit">Comment</button>   
            </div>   
        </div>
        <div class="center-align" id="commentsforpost">
            <button class="btn waves-light" id="showhidecomments">
                Show all Comments
                <i class="small material-icons">arrow_drop_down</i>
            </button>
            <div class="row" id="allcomments"><div>
        </div>`
    )

    $("#allcomments").slideToggle('fast');

    $("#showhidecomments").click(()=>{
        showhidecomments();
        $("#allcomments").slideToggle('fast');        
    });

    $("#commentsforpost").css("display","none");
}

function showhidecomments(){

    let current = $("#showhidecomments").text().trim().substring(0,4);

    if(current==="Show")
    {
        $("#showhidecomments").html(
            `Hide all Comments
            <i class="small material-icons">arrow_drop_up</i>`);
    }
    else if(current==="Hide")
    {
        $("#showhidecomments").html(
            `Show all Comments
            <i class="small material-icons">arrow_drop_down</i>`);
    }
}

function validation(title,body){

    const validtitle = /(\S+\s*){3,}/;
    const validbody = /\S+(\s\S+){2,}/;

    if(!validtitle.test(title))
    {
        $("#title").css("border-color","red");
        $("#titleerror").css("display","block");
    }
    else{
        $("#title").css("border-color","black");
        $("#titleerror").css("display","none");
    }
    
    if(!validbody.test(body))
    {
        $("#body").css("border-color","red");
        $("#bodyerror").css("display","block");
    }
    else{
        $("#body").css("border-color","black");
        $("#bodyerror").css("display","none");
    }
    
    if(validtitle.test(title) && validbody.test(body))
    {
        return true;
    }
    else{
        return false;
    }
}

function loadcomments(post){

    $("#wait").css("display", "block");
    fetch("http://localhost:3000/comments")
        .then(response=>response.json()
            .then(data=>{                               
                let cmntarray = data.filter(comment=>comment.postId == post.id);
                if(cmntarray.length>=1)
                {
                    $("#commentsforpost").css("display","block");
                    cmntarray.map(comment=>{
                        $("#allcomments").append(
                            `<div class="col s12">
                                <div class="card white-grey darken-1">
                                    <div class="card-action">
                                        <p>${comment.body}</p>          
                                    </div>
                                </div>
                            </div>`
                        )
                    })
                }                
            })
        );                        
    $("#wait").css("display", "none");
}

function submitcomment(postId){

    let cmnt = $("#comment").val().trim();
    let validcmntregex = /\S+/;

    if(validcmntregex.test(cmnt))
    {
        let comment = {
            "body":cmnt,
            "postId":postId
        }

        fetch("http://localhost:3000/comments", {
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify(comment)      
        })
        .then(response => {
            if(response.ok){
                if($("#allcomments").length)
                {
                    handleresponse("Success!!!", "New comment has been added for this post.")
                    $("#dialog").dialog("open");  
                    $("#allcomments").prepend(
                        `<div class="col s12">
                            <div class="card white-grey darken-1">
                                <div class="card-action">
                                    <p>${cmnt}</p>          
                                </div>
                            </div>
                        </div>`
                    )
                }                
            }
            else{
                handleresponse("Error", "HTTP status " + response.status);
                throw new Error("HTTP status " + response.status);
            }
        })
        .then(()=>{$("#main").append(" ")})
    }
}

function makepost(){

    let title = $("#title").val().trim();
    let body = $("#body").val().trim();

    if(validation(title,body))
    {                                
        let today = new Date();
        let date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        let dateTime = date+' '+time;        
    
        return {
            "title":title,
            "body":body,
            "date":dateTime
        }
    }
    else
    {
        return false;
    }
}

function updatepost(postId,editedpost){
    $("#wait").css("display","block");                
    fetch(`http://localhost:3000/posts/${postId}`, {
        method: "PUT",
        headers: {
        "Content-Type":"application/json"
        },
        body: JSON.stringify(editedpost)      
    })
    .then(response => {                
        if(response.ok){
            $("#wait").css("display","none");
            handleresponse("Success!!!","Post has been updated");
        }
        else{
            $("#wait").css("display","none");
            handleresponse("Error","HTTP status " + response.status);
            throw new Error("HTTP status " + response.status);            
        }                     
    })
}

function deletepost(postId){
    fetch(`http://localhost:3000/posts/${postId}`, {method: "DELETE"})
    .then(response => {
        if(response.ok){
            handleresponse("Success!!!","Post has been deleted");
        }
        else{
            handleresponse("Error","HTTP status " + response.status);
            throw new Error("HTTP status " + response.status);
        }
    })
}

function handleconfirmation(postId,editedpost)
{    
    if(editedpost === undefined)
    {
        $("#dialog").dialog( "option", "title", "Delete Confirmation" );    
        $("#dialog").text("Do you really want to delete this post?");   
        $("#dialog").dialog("option","buttons",
            [
                {
                    text: "Yes",
                    icon: "ui-icon-check",
                    click: function(){deletepost(postId);}
                },
                {
                    text: "No",
                    icon: "ui-icon-close",
                    click: function(){$(this).dialog( "close" );}
                }
            ]                               
        );                            
        $("#dialog").dialog("open");
    }
    else
    {
        $("#dialog").dialog( "option", "title", "Update Confirmation" );  
        $("#dialog").text("Do you really want to update this post?");   
        $("#dialog").dialog("option","buttons",
            [
                {
                    text: "Yes",
                    icon: "ui-icon-check",
                    click: function(){updatepost(postId,editedpost);}
                },
                {
                    text: "No",
                    icon: "ui-icon-close",
                    click: function(){$(this).dialog( "close" );}
                }
            ]                               
        );                            
        $("#dialog").dialog("open");
    }    
}

function handleresponse(successorerror,text){
       
    $("#dialog").dialog( "option", "title", successorerror );                                        
    $("#dialog").text(text);
    $("#dialog").dialog("option","buttons",
        [
            {
                text: "Ok",
                icon: "ui-icon-check",
                click: function(){$(this).dialog("close");}
            }
        ]                               
    );
}