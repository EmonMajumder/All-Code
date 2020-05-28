$(function() {
  let dealercards= [];
  let playercards= [];
  let dealerscore=0;
  let playerscore=0;
  let deckid = 0;
  let result = "";
  let hiddencard = "";
  let round = 0;
  let totalcoin = 1000;
  let bet = 100;
  let betbase = 100;
  let remaining = 52;
  const deck="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
  let card = "https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1"; 
  
  
  //----------------------------------------------------------------------------Modals---------------------------------------------------------------------------------

  $("#modalbet").modal();
  $("#betamount").html(setcoininplaceof0(betbase));
  $("#totalcoinown").html("You Own: "+setcoininplaceof0(totalcoin));


  $("#btnmodalStartGame").click(()=>{
    $("#btnPlay").text("Restart");
    $("#coverphoto").css("display","none");
    $("#modalbet").modal("close");
    nextround();
  });

  coverphoto
  
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

  $("#modalroundresult").modal();

  $("#btnmodalnextround").click(()=>{
    $("#modalroundresult").modal("close");
    nextround();
  });

  $("#btnmodalrestart").click(()=>{
    $("#modalroundresult").modal("close");
    startnewgame();
  });  

  $("#btnmodalraisebet").click(()=>{
    $("#modalroundresult").modal("close");
  });

  function setcoininplaceof0(value){
    return value.toString(10).replace(/0/g,`<img src="coin.png">`);
  }

  //----------------------------------------------------------------------------Buttons---------------------------------------------------------------------------------
  $("#btnPlay").click(()=>{
    startnewgame();     
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

  $("#btnHit").css("display","none");
  $("#btnStay").css("display","none");
  $("#btnNext").css("display","none");
  
  $("#card").click(function(){
    $(this).toggleClass('is-flipped');
  })
  
//----------------------------------------------------------------------------Functions---------------------------------------------------------------------------------
  function startnewgame(){    
    getdeck.then((deck)=>{
      totalcoin = 1000;
      deckid = deck.deck_id;
      getcard();    
    });   
  }

  function didplayerlose()
  {
    if(playerscore>21)
    {
      result = "You Lose";     
    }
    showorhidebutton();
  }

  function winorlose(){

    if(dealerscore>21 && playerscore<=21)
    {
      result = "You Won";
      totalcoin+=bet*2;
      round++;
    }
    else if(21-dealerscore > 21-playerscore)
    {
      result = "You Won";
      totalcoin+=bet*2;
      round++;
    }
    else if(21-dealerscore < 21-playerscore){
      result = "You Lose";
      round++;
    }
    else{
      result = "Draw";
      totalcoin+=bet;
      round++;
    }    

    $("#coin").text("You Own: "+totalcoin);
    $("#totalcoinown").html("You Own: "+setcoininplaceof0(totalcoin));
    showorhidebutton();    
  };

  function showorhidebutton(){
    if(result=="Draw" || result=="You Won" || result=="You Lose")
    { 
      $("#coinafter").text(`${totalcoin}`);
      $("#roundresult").text(`${result}`);

      if(totalcoin==0)
      {
        $("#btnmodalraisebet").css("display","none");
        $("#btnmodalnextround").css("display","none");
      }else{
        $("#btnNext").css("display","inline");
      }

      $("#modalroundresult").modal("open");        
      $("#btnHit").css("display","none");
      $("#btnStay").css("display","none");
      
      if(bet>totalcoin)
      {
        bet=totalcoin;
      }
    }
    else{
      $("#btnHit").css("display","inline");
      $("#btnStay").css("display","inline");
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

    $("#roundandcoin").css("visibility","visible");

    $("#coin").text(`You Own: ${totalcoin}`);
    $("#round").text(`Round: ${round}`);    
    $("#betting").text(`Bet: ${bet}`)

    if(totalcoin==0)
    {
      $("#btnNext").css("display","none");
    }
    $("#dealercards").empty();
    $("#playercards").empty();

    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=4")
      .then(response => response.json())
      .then(data => 
      {
        console.log(data.deck_id);
        remaining = data.remaining;        
      
        for(let i=0; i<data.cards.length;i++)
        {
          if(i%2 == 0)
          {
            playercards.push(data.cards[i].value);
            $("#playercards").append(`<img src="${data.cards[i].image}">&nbsp;&nbsp;`)
          }   
          else{
            dealercards.push(data.cards[i].value);
            if(i==1)
            {
              $("#dealercards").append(
                `<div class="scene scene--card">
                  <div class="tcard">
                    <img class="card__face card__face--front" src="cardback.png">
                    <img class="card__face card__face--back" src="${data.cards[1].image}">
                  </div>
                </div>&nbsp;&nbsp;`)
            }
            else{
              $("#dealercards").append(`<img src="${data.cards[i].image}">&nbsp;&nbsp;`);
            }
          }
        }

        $(".tcard").click(function(){
          $(this).toggleClass('is-flipped');
        })

        dealerscoreresult();
        playerscoreresult();
        didplayerlose();
      })
  }

  function hit(){
    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data =>
      {
        if(data.success){
          console.log(data);
          playercards.push(data.cards[0].value);
          $("#playercards").append(`<img src="${data.cards[0].image}">&nbsp;&nbsp;`);       
          playerscoreresult();
          didplayerlose();
        }
      })           
    }

  function stay(){
    $(".tcard").toggleClass('is-flipped');

    $(".tcard").bind("transitionend",function(){
      if(dealerscore<17)
      {
        fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
        .then(response => response.json())
        .then((data)=>{
          dealercards.push(data.cards[0].value);
          $("#dealercards").append(`<img src="${data.cards[0].image}">`);
        })
        .then(()=>{
          dealerscoreresult();
          $("#dealer_score").text(`Dealer: ${dealerscore}`);
        })       
      }else{
        $("#dealer_score").text(`Dealer: ${dealerscore}`);
      }
      wait(2000);
      winorlose();
    })  
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

  function dealerscoreresult()
  {
    dealerscore = calculatescore(dealercards);

    if(dealerscore>21 && dealercards.includes("ACE"))
    {
      dealerscore-=10;
      dealercards[dealercards.indexOf("ACE")] = "A";
    }

    $("#dealer_score").html(`<h5>Dealer: ${dealerscore-cardvalue(dealercards[0])}</h5>`);
  }

  function playerscoreresult()
  {
    playerscore = calculatescore(playercards);

    if(playerscore>21 && playercards.includes("ACE"))
    {
      playerscore-=10;
      playercards[playercards.indexOf("ACE")] = "A";
    }

    $("#player_score").text(`Player: ${playerscore}`);
  }

  function calculatescore(cardset){
    let score = 0;
    for(var i=0 ; i<cardset.length; i++)
    {
      score = score+cardvalue(cardset[i]);
    }
    return score;
  }


  //------------------------------------------------------------------------FunctionswithPromise------------------------------------------------------------------------------
  let getdeck = new Promise((resolve,reject)=>{
    fetch(deck)
    .then(response => response.json())
    .then(data =>
    {        
      if(data.success)
      {
        resolve(data);
      }
      else{
        reject("Error");
      }
    })
  })

  function getcard(){
    getnextcard = new Promise((resolve,reject)=>{
      fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data =>
      {        
        
      })
    })
  }
})
  