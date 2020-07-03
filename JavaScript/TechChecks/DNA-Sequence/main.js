(function(tests){

    var DATA_URL = "https://mikecaines.com/api/map.json";
    var DNA_SEQUENCE = "GTGCCAATGTTACTGCTAAATCTCTATATACAGTGGCTTAAGGATGGGGGGCCCAGCAGCGGCCGACCCCCCCCCTCAGTGTGGAATCAACCGGAATTGAGG";
    
    // Extract Codons as JavaScript Array from the DNA Sequence String.
    var extractCodonsFromDNA = function(dnaSequence)
    {
      var codons = [];
      var letters = [];
      var eachcodon = "";
      var count = 0;
      var limit = 3;
  
      // TODO: ADD CODE TO COMPLETE THE FUNCTION HERE...
      // you'll get an error notification in the console until the function is completed correctly
        
      letters = dnaSequence.split("");

      for(var i=0;i<letters.length;i++)
      {
          eachcodon += letters[i];
          count++;
          if(count==limit)
          {
            codons.push(eachcodon);
            count = 0;
            eachcodon ="";
          }
      }        
      //console.log(codons); 

      return codons;
    }
    
    // Compare the Codons array with the map of Amino Acids found in the json data.
    // Add any matches to the aminos array.
    var translateCodonsToAminos = function(codons, jsonData) 
    {
      var aminos = [];
      
      // TODO: ADD CODE TO COMPLETE THE FUNCTION HERE...
      // you'll get an error notification in the console until the function is completed correctly
      codons.forEach(currentcodon=>
      {
        //console.log(currentValue);        
        jsonData.forEach(aminoacid=>
        {
          aminoacid.codons.forEach(aminoacidCodon=>
          {
            if(currentcodon == aminoacidCodon)
            {
              aminos.push(aminoacid.abbr);
            }
          })
        })
      })
      
      //console.log(aminos);
      return aminos;
    }
    
    var runProgram = function () {
      var codons = extractCodonsFromDNA(DNA_SEQUENCE); //DO NOT MODIFY
      var aminos; //DO NOT MODIFY    

      // TODO: ENTER CODE TO LOAD DATA FROM API HERE.      

      fetch(DATA_URL)
      .then(response => response.json())
      .then(json=>
        {
        //console.log(json);
        aminos = translateCodonsToAminos(codons, json); //DO NOT MODIFY...but you can uncomment and move when ready
        tests.runTests(codons, aminos)//DO NOT MODIFY...but you can move when ready

        console.log("Finished");
        })
 
      //ONCE YOU HAVE YOUR API CALL WORKING, UNCOMMENT THE LINE ABOVE THE runTests line AND APPLY 
      //BOTH LINES (including the test line) WITHIN THE CODE ABOVE WHERE YOU RECEIVE YOUR JSON DATA FROM YOUR API CALL...
      //DO NOT MODIFY THE LINES EXCEPT FOR UNCOMMENTING THEM AND MOVING THEM TO THE CORRECT LOCATION ABOVE IN CODE      
      
    }

    runProgram(); // DO NOT MODIFY
  
  })(tests);