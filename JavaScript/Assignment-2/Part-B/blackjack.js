var dealercards= [];
var playercards= [];
var dealerscore=0;
var playerscore=0;
var deckid = 0;
var result = "";
var alertmsg = false;


function winorlose(){  

  result = "";

  if ((dealerscore>21 && playerscore>21) || (dealerscore==21 && playerscore==21))
  {
    result = "Draw";
  }
  else if(dealerscore>21 || playerscore==21)
  {
    result = "You Won";
  }
  else if(dealerscore==21 || playerscore> 21)
  {
    result = "You Lose";
  }

  if(result=="Draw" || result=="You Won" || result=="You Lose")
  {
    document.getElementById("banner").innerHTML = `<h1>${result}<h1>`;
    document.getElementById("btnStart").value = "Restart Game";
    alertmsg = true;
  }
};

function startgame(){
    var deck="https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=6";

    dealercards= [];
    playercards= [];
    dealerscore= 0;
    playerscore= 0;
    alertmsg = false;

    for(var i=1; i<=20;i++)
    {
      document.getElementById("image"+i).innerHTML="";
    }
    
    fetch(deck)
    .then(response => response.json())
    .then(data =>
    {
      deckid = data.deck_id;
      fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=4")
      .then(response => response.json())
      .then(data => 
        {
        document.getElementById("banner").innerHTML = "Let's Play Blackjack"; 
        document.getElementById("image1").innerHTML=`<img src="${data.cards[0].image}" width="200px" height="300px">`;
        document.getElementById("image2").innerHTML=`<img src="${data.cards[1].image}" width="200px" height="300px">`;
        document.getElementById("image11").innerHTML=`<img src="${data.cards[2].image}" width="200px" height="300px">`;
        document.getElementById("image12").innerHTML=`<img src="${data.cards[3].image}" width="200px" height="300px">`;
        
        for(let i=0; i<data.cards.length;i++)
        {
          if(i<=1)
            {
              cardvalue(data.cards[i].value,dealercards)
            }
            else
            {
              cardvalue(data.cards[i].value,playercards)
            }   
        }

        dealerscoreresult();
        playerscoreresult();
        winorlose();
        })
        .catch(error => console.error(error))  
    })
};

function hit(){
  if(alertmsg)
  {
    alert(result+". Please restart Game.");
  }
  else{
    fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data => 
        {  
        cardvalue(data.cards[0].value,playercards);
        document.getElementById("image"+1+playercards.length).innerHTML=`<img src="${data.cards[0].image}" width="200px" height="300px">`;        
        playerscoreresult();
        winorlose();
        })
        .catch(error => console.error(error))  
  }  
}

function stay(){
  if(alertmsg)
  {
    alert(result+". Please restart Game.");
  }
  else{
  fetch("https://deckofcardsapi.com/api/deck/"+deckid+"/draw/?count=1")
      .then(response => response.json())
      .then(data => 
        {
        cardvalue(data.cards[0].value,dealercards);
        document.getElementById("image"+dealercards.length).innerHTML=`<img src="${data.cards[0].image}" width="200px" height="300px">`;        
        dealerscoreresult();
        winorlose();
        })
        .catch(error => console.error(error))
  }  
}

function cardvalue(cardvalue,turn)
{
  if(cardvalue == "JACK" || cardvalue == "QUEEN" || cardvalue == "KING")
  {          
    turn.push(10)           
  }
  else if(cardvalue == "ACE")
  {         
    turn.push(11)         
  }
  else
  {         
    turn.push(parseInt(cardvalue,10));
  }
}

function dealerscoreresult()
{
  dealerscore = 0;
  for(var i=0 ; i<dealercards.length; i++)
        {
          dealerscore = dealerscore+dealercards[i];
        }
        document.getElementById("dealer_score").innerHTML=`<h2>Dealer: ${dealerscore}</h2>`;
}

function playerscoreresult()
{
  playerscore = 0;
  for(var i=0 ; i<playercards.length; i++)
        {
          playerscore = playerscore+playercards[i];
        }
        document.getElementById("player_score").innerHTML=`<h2>Player: ${playerscore}</h2>`;
}
  