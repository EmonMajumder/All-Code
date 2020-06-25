$(function() {
  let dealercards= [];
  let playercards= [];
  let playercards2=[];
  let playercards2image="";
  let dealerscore=0;
  let playerscore=0;
  let playerscore2=0;
  let deckid = 0;
  let result = "";
  let result2 = "";
  let round = 0;
  let totalcoin = 1000;
  let totalcoinbase = 1000;
  let bet = 100;
  let bet2 = 100;
  let betbase = 100;
  let remaining = 52;
  let playercardcount = 2;
  let playercardcount2 = 2;
  let dealercardcount = 2;
  let turn = 0;
  let h1 = 0;
  let h2 = 0;
  const deck="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
  
  //----------------------------------------------------------------------------hiding elements------------------------------------------------------------------------
  $("#btnHit2").css("display","none");
  $("#btnStay2").css("display","none");
  $("#btnmodalclose").css("display","none");
  









  //----------------------------------------------------------------------------Modals---------------------------------------------------------------------------------

  $("#modalbet").modal();
  $("#modalroundresult").modal();
  $("#modalroundresult2").modal();

  $("#btnmodalStartGame").click(()=>{
    $("#btnPlay").text("Restart");
    $("#coverphoto").css("display","none");
    $("#roundandcoin").css("visibility","visible");
    $(".hide").removeClass("hide");
    $("#modalbet").modal("close");
    startnewgame();
  });
  
  $("#betup").click(()=>{
    if(bet<totalcoin)
    {
      bet+=betbase;
    }
    if(bet>9999)
    {
      $("#betholder").css("width","200px");
    }
    $("#betamount").html(setcoininplaceof0(bet));
  });

  $("#betdown").click(function(){
    if(bet > betbase)
    {
      bet-=betbase;
    }    
    $("#betamount").html(setcoininplaceof0(bet));
  });  

  $("#btnmodalclose").click(()=>{
    $("#modalroundresult").modal("close");
  });

  $("#btnmodalnextround").click(()=>{
    $("#modalroundresult").modal("close");
    nextround();
  });

  $("#btnmodalrestart").click(()=>{
    $("#modalroundresult").modal("close");
    $("#btnPlay").trigger("click");
  });  

  $("#btnmodalraisebet").click(()=>{
    $("#betamount").html(setcoininplaceof0(bet));
    $("#totalcoinown").html(setcoininplaceof0(totalcoin));
    $("#modalroundresult").modal("close");
  });

  function setcoininplaceof0(value){
    return value.toString(10).replace(/0/g,`<img src="coin.png">`);
  }

  //----------------------------------------------------------------------------Buttons---------------------------------------------------------------------------------
  $("#btnPlay").click(()=>{
    bet = betbase;
    totalcoin = totalcoinbase;
    round = 0;
    $("#betamount").html(setcoininplaceof0(bet));
    $("#totalcoinown").html(setcoininplaceof0(totalcoin));         
  });

  

  $("#btnHit").click(()=>{
    hit();
  });

  $("#btnStay").click(()=>{
    stay();
  });

  $("#btnNext").click(()=>{
    nextround();
  });

  $("#btnSplit").click(()=>{
    split();
  });

  $("#btnHit").css("display","none");
  $("#btnStay").css("display","none");
  $("#btnNext").css("display","none");
  $("#btnSplit").css("display","none");


//---------------------------------------------------------------------------Bind Animation----------------------------------------------------------------------------- 

  $("#animationdealercard").bind("animationend",function(){
    $("#animationdealercard").toggleClass("popIn");
    $("#dealer_score").toggleClass("popOut popIn");
    $("#dealer_score").text(dealerscore);  
    $("#animationdealercard2").toggleClass("popIn");
  })

  $("#animationdealercard2").bind("animationend",function(){
    $("#animationdealercard2").toggleClass("popIn");
    if(dealerscore<17){
      getcardfordealer();
    }
    else{
      winorlose();
    }    
    $("#dealer_score").removeClass("popIn");
  })

  $("#animation").bind("animationend",function(){
    $("#animation").toggleClass("popIn");
    $("#player_score").removeClass("popIn");
    if(playercardcount == 2){
      isitblackjack();
    }
    else{
      didplayerlose();
    }  
    
    if(turn == 1){
      h1 = $("#firstset").height();
      h2 = $("#extraset").height();          
  
      if(h1>h2){
        $("#extraset").height(h1);
      }else{
        $("#firstset").height(h2);
      }
    }
  })

  $("#animation2").bind("animationend",function(){
    $("#animation2").toggleClass("popIn");
    $("#player_score").removeClass("popOut");
    playerscoreresult();
    console.log("hit2");
  })

  $("#animationdealercard3").bind("animationend",function(){
    $("#animationdealercard3").removeClass("popIn");
    $("#dealer_score").removeClass("popIn");
  })

//----------------------------------------------------------------------------Functions---------------------------------------------------------------------------------


  function startnewgame(){
    getnewdeck(nextround);
  }

  function getnewdeck(_callback){
    fetch(deck)
    .then(response => response.json())
    .then(data =>
    {        
      deckid = data.deck_id;      
    })
    .then(()=>{
      _callback();
    })    
  }

  function isitblackjack(){
    if(playerscore == 21){
      result = "BlackJack";

    }
    showorhidebutton();
  }

  function didplayerlose()
  {
    if(playerscore>21)
    {
      result = "You Lose";  
      extrasetclicked();       
    }
    showorhidebutton();    
  }

  function winorlose(){
    if (turn==0){
      if(dealerscore>21 && playerscore<=21)
      {
        result = "You Won";
        totalcoin+=bet*2;
      }
      else if(21-dealerscore > 21-playerscore)
      {
        result = "You Won";
        totalcoin+=bet*2;
      }
      else if(21-dealerscore < 21-playerscore){
        result = "You Lose";
      }
      else{
        result = "Draw";
        totalcoin+=bet;
      }

      $("#coin").text(totalcoin);
      $("#totalcoinown").html(setcoininplaceof0(totalcoin));
      showorhidebutton(); 
    }else{
      if(dealerscore>21 && playerscore<=21)
      {
        result = "You Won";
        totalcoin+=bet*2;
      }
      else if(21-dealerscore > 21-playerscore)
      {
        result = "You Won";
        totalcoin+=bet*2;
      }
      else if(21-dealerscore < 21-playerscore){
        result = "You Lose";
      }
      else{
        result = "Draw";
        totalcoin+=bet;
      }

      if(dealerscore>21 && playerscore2<=21)
      {
        result2 = "You Won";
        totalcoin+=bet2*2;
      }
      else if(21-dealerscore > 21-playerscore2)
      {
        result2 = "You Won";
        totalcoin+=bet2*2;
      }
      else if(21-dealerscore < 21-playerscore2){
        result2 = "You Lose";
      }
      else{
        result2 = "Draw";
        totalcoin+=bet2;
      }

      $("#coin").text(totalcoin);
      $("#totalcoinown").html(setcoininplaceof0(totalcoin));
      showorhidebutton(); 
    }
        

   
  };

  function showorhidebutton(){
    if(result=="Draw" || result=="You Won" || result=="You Lose" || result=="BlackJack")
    { 
      $("#coinafter").text(totalcoin);

      if(turn==0){
        $("#roundresult").text(result);
      }else{
        $("#roundresult").text("Left Hand: "+result);
        $("#roundresult").append("<br>Right Hand: "+result2);
      }
      

      if(turn == 0){
        $("#btnmodalrestart").css("display","inline");

        if(totalcoin==0)
        {
          $("#btnmodalraisebet").css("display","none");
          $("#btnmodalnextround").css("display","none");
        }else{
          $("#btnNext").css("display","inline");
          $("#btnmodalraisebet").css("display","inline");
          $("#btnmodalnextround").css("display","inline");
        }        
        if(bet>totalcoin)
        {
          bet=totalcoin;
          if(bet<betbase){
            bet=betbase;
          }
        }
      }else{
        turn = 0;
        $("#firstset").off("click");
        $("#btnmodalclose").css("display","inline");
        $("#btnmodalrestart").css("display","none");
        $("#btnmodalraisebet").css("display","none");
        $("#btnmodalnextround").css("display","none");        
        $("#btnNext").css("display","none");
        $("#btnmodalraisebet").css("display","none");
        $("#btnmodalnextround").css("display","none");
      }  

      $("#btnHit").css("display","none");
      $("#btnStay").css("display","none");      

      $("#modalroundresult").modal("open");           
    }
    else{
      $("#btnHit").css("display","inline");
      $("#btnStay").css("display","inline");
      if(playercards[0] == playercards[1]){
        if(bet <= totalcoin){
          $("#btnSplit").css("display","inline");
        }else{
          alert("You don't have enough coin to split");
        }            
      }
      $("#btnNext").css("display","none");
    }
  }

  function wait(ms){
    var start = new Date().getTime();
    var end = start;
    while(end < start + ms) {
      end = new Date().getTime();
   }
 }

  function nextround(){
    dealercards= [];
    playercards= [];
    dealerscore= 0;
    playerscore= 0;
    totalcoin-=bet;
    round++;
    result = "";
    playercardcount = 2;

    $("#coin").text(totalcoin);
    $("#round").text(round);    
    $("#betting").text(bet);
    $("#btnNext").css("display","none");
    $("#btnSplit").css("display","none");
  

    $("#dealercards").empty();
    $("#playercards").empty();

    $("#extraset").empty();
    $("#extraset").removeClass("selected");
    $(".split").toggleClass("s12 s6");
    $("#firstset").height("auto");
    $("#extraset").height("auto");

    $("#dealer_score").text("");
    $("#player_score").text("");

    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=4")
      .then(response => response.json())
      .then(data => 
      {
        remaining = data.remaining;

        $("#playercards").append(`<img class="cardgiven" id="playercard1" src="${data.cards[0].image}">`)
        playercards.push(data.cards[0].value);

        $("#dealercards").append(`<img class="cardgiven" id="dealercard1" src="${data.cards[1].image}">`)
        dealercards.push(data.cards[1].value);

        $("#playercards").append(`&nbsp;&nbsp;<img class="cardgiven" id="playercard2" src="${data.cards[2].image}">`)
        playercards2image = data.cards[2].image;
        //playercards.push(data.cards[2].value);
        playercards.push(data.cards[0].value);

        $("#dealercards").append(
          `&nbsp;&nbsp;<div class="scene cardgiven" id="dealercard2">
            <div class="tcard">
              <img class="card__face card__face--front" src="cardback.png">
              <img class="card__face card__face--back" src="${data.cards[3].image}">
            </div>
          </div>`)
        dealercards.push(data.cards[3].value);        

        $("#playercard1").toggleClass("driveInTop");

        $("#playercard1").bind("animationend",function(){
          $("#dealercard1").toggleClass("driveInTop");
        })

        $("#dealercard1").bind("animationend",function(){
          $("#playercard2").toggleClass("driveInTop");
        })

        $("#playercard2").bind("animationend",function(){
          $("#dealercard2").toggleClass("driveInTop");
        })

        $("#dealercard2").bind("animationend",function(){
          dealerscoreresult();
          playerscoreresult();
        })       
      })
  }

  function hit(){

    $("#btnSplit").css("display","none");
    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data =>
      {
        if(data.success){
          playercardcount++;
          playercards.push(data.cards[0].value);

          $("#playercards").append(`&nbsp;<img class="cardgiven" id="playercards${playercardcount}" src="${data.cards[0].image}">&nbsp;`);

          $(`#playercards${playercardcount}`).toggleClass("driveInTop"); 
          $(`#playercards${playercardcount}`).bind("animationend",function(){
            $("#player_score").toggleClass("popIn popOut");
            $("#animation2").toggleClass("popIn");                      
          })          
        }
      })           
  }

  function getcardfordealer(){
    dealercardcount++;
    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
        .then(response => response.json())
        .then((data)=>{
          dealercards.push(data.cards[0].value);
          $("#dealercards").append(`&nbsp;&nbsp;<img class="cardgiven" id="dealercard${dealercardcount}" src="${data.cards[0].image}">`);
          $(`#dealercard${dealercardcount}`).toggleClass("driveInTop"); 
          $(`#dealercard${dealercardcount}`).bind("animationend",function(){
            dealerscoreresultfinal();
          })                      
        })  
  }

  function stay(){
    if(turn == 0){
      $(".tcard").toggleClass('is-flipped');  

      $(".tcard").bind("transitionend",function(){
          dealerscoreresultfinal();
        });
    }else{
      extrasetclicked();
    }
  }

  function cardvalue(cardinhand)
  {
    if(cardinhand == "JACK" || cardinhand == "QUEEN" || cardinhand == "KING")
    {          
      return 10;           
    }
    else if(cardinhand == "ACE")
    {         
      return 11;          
    }
    else if(cardinhand == "A")
    {         
      return 1;          
    }
    else
    {         
      return parseInt(cardinhand,10);
    }
  }
  function dealerscoreresultfinal()
  {
    dealerscore = calculatescore(dealercards);

    if(dealerscore>21 && dealercards.includes("ACE"))
    {
      dealerscore-=10;
      dealercards[dealercards.indexOf("ACE")] = "A";
    }

    $("#dealer_score").toggleClass("popIn popOut");
    $("#animationdealercard").toggleClass("popIn");  
  }

  function dealerscoreresult()
  {
    dealerscore = calculatescore(dealercards);

    if(dealerscore>21 && dealercards.includes("ACE"))
    {
      dealerscore-=10;
      dealercards[dealercards.indexOf("ACE")] = "A";
    }

    $("#dealer_score").toggleClass("popIn");
    $("#animationdealercard3").toggleClass("popIn");
    $("#dealer_score").text(dealerscore-cardvalue(dealercards[1]));    
  }

  function playerscoreresult()
  {
    console.log("playerscoreresult");
    playerscore = calculatescore(playercards);

    if(playerscore>21 && playercards.includes("ACE"))
    {
      playerscore-=10;
      playercards[playercards.indexOf("ACE")] = "A";
    }

    $("#player_score").toggleClass("popIn");
    $("#animation").toggleClass("popIn");
    $("#player_score").text(playerscore);
  }

  function calculatescore(cardset){
    let score = 0;
    for(var i=0 ; i<cardset.length; i++)
    {
      score = score+cardvalue(cardset[i]);
    }
    return score;
  }




//---------------------------------------------------------------------------------------------Player2ndhand---------------------------------------------------------------------------

  function firstsetclicked(){
    $("#firstset").addClass("selected");
    $("#extraset").removeClass("selected");
    $("#btnHit").css("display","inline");
    $("#btnHit2").css("display","none");
    $("#btnStay").css("display","inline");
    $("#btnStay2").css("display","none");
  }

  function extrasetclicked(){
    $("#extraset").addClass("selected");
    $("#firstset").removeClass("selected");
    $("#btnHit2").css("display","inline");
    $("#btnHit").css("display","none");
    $("#btnStay2").css("display","inline");
    $("#btnStay").css("display","none");
  }

  function split(){

    turn = 1;    
    bet2 = bet;
    totalcoin -= bet2; 
       
    $("#btnHit").css("display","none");
    $("#btnStay").css("display","none");
    $("#coin").text(totalcoin);
    $("#betting").text(bet);

    playercards2.push(playercards[1]);
    playerscore2 = cardvalue(playercards2[0]);
    playerscore /= 2; 
    $("#player_score").text(playerscore);
    playercards.pop();  
    $(".split").toggleClass("s12 s6");
    $("#btnSplit").css("display","none");
    $("#extraset").html(
      `<div class="center-wrapper cardshown">
        <div>You&nbsp;</div><div id="player2_score">${playerscore2}</div>
      </div>
      <div class="cardshown" id="playercards2"><img id="playercards21" src="${playercards2image}"></div>`
      );
      $("#playercard2").css("display","none"); 

    firstsetclicked();
  }

  $("#btnHit2").click(function(){
    hit2();
  })

  $("#animation3").bind("animationend",function(){
    $("#animation3").toggleClass("popIn");
    $("#player2_score").removeClass("popIn");

    h1 = $("#firstset").height();
    h2 = $("#extraset").height();          

    if(h1>h2){
      $("#extraset").height(h1);
    }else{
      $("#firstset").height(h2);
    }

    didplayerlose2();    
  })

  $("#animation4").bind("animationend",function(){
    $("#animation4").toggleClass("popIn");
    $("#player2_score").removeClass("popOut");
    playerscoreresult2();
  })

  function didplayerlose2()
  {
    if(playerscore2>21)
    {
      result2 = "You Lose";    
    }
    showorhidebutton2();
  }

  function hit2(){

    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data =>
      {
        if(data.success){
          playercardcount2++;
          playercards2.push(data.cards[0].value);

          $("#playercards2").append(`&nbsp;<img class="cardgiven" id="playercards2${playercardcount2}" src="${data.cards[0].image}">&nbsp;`);

          $(`#playercards2${playercardcount2}`).toggleClass("driveInTop");

          $(`#playercards2${playercardcount2}`).bind("animationend",function(){
            $("#player2_score").toggleClass("popIn popOut");
            $("#animation4").toggleClass("popIn");                      
          })          
        }
      })           
  }

  function playerscoreresult2(){
    console.log("playerscoreresult2");
    playerscore2 = calculatescore(playercards2);

    if(playerscore2>21 && playercards2.includes("ACE"))
    {
      playerscore2-=10;
      playercards2[playercards2.indexOf("ACE")] = "A";
    }

    $("#player2_score").toggleClass("popIn");
    $("#animation3").toggleClass("popIn");
    $("#player2_score").text(playerscore2);
  }


  function showorhidebutton2(){
    if(result2=="Draw" || result2=="You Won" || result2=="You Lose" || result2=="BlackJack")
    { 
      $("#coinafter").text(totalcoin);
      $("#roundresult").text(result2);

      if(turn == 0){
        $("#btnmodalrestart").css("display","inline");

        if(totalcoin==0)
        {
          $("#btnmodalraisebet").css("display","none");
          $("#btnmodalnextround").css("display","none");
        }else{
          $("#btnNext").css("display","inline");
          $("#btnmodalraisebet").css("display","inline");
          $("#btnmodalnextround").css("display","inline");
        }
        
        if(bet>totalcoin)
        {
          bet=totalcoin;
          if(bet<betbase){
            bet=betbase;
          }
        }
      }else{
        turn = 0;
        $("#btnmodalclose").css("display","inline");
        $("#btnmodalrestart").css("display","none");
        $("#btnmodalraisebet").css("display","none");
        $("#btnmodalnextround").css("display","none");        
        $("#btnNext").css("display","none");
        $("#btnmodalraisebet").css("display","none");
        $("#btnmodalnextround").css("display","none");
      }  

      $("#btnHit2").css("display","none");
      $("#btnStay2").css("display","none");      

      $("#modalroundresult").modal("open");           
    }
    else{
      $("#btnHit2").css("display","inline");
      $("#btnStay2").css("display","inline");
      $("#btnNext").css("display","none");
    }
  }

  $("#btnStay2").click(()=>{
    stay2();
  });

  function stay2(){
    $(".tcard").toggleClass('is-flipped');
    $(".tcard").bind("transitionend",function(){
      dealerscoreresultfinal();
    });
  }
})

  