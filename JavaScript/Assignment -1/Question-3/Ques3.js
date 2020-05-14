function consecutiveNumber()
{
    var count = 0;
    var countStreak = 0;
    //var arr = [1, 2, 3, 6, 9, 34, 2];
    //var arr =[1,3,5];
    //var arr= [3, 2, 7, 5, 6, 7, 9, 3, 9, 8, 9, 10, 23, 2, 1, 2, 3];
    var arr= [100, 101, 102, 3, 4, 5, 6, 9];
    var numbers = 0;
    var total = 0;

    for(var i=0;i<arr.length-1;i++)
    {
        if(arr[i+1]-arr[i] == 1)
        {
            if(count==0)
            {
                count = arr[i];
                countStreak++;
            }
            countStreak++;
            count = count + arr[i+1];
        }
        else
        {
            if(countStreak>numbers)
            {
                numbers = countStreak;
                total = count;               
            }
            else if(countStreak=numbers)
            {
                if(count>total)
                {
                    total = count;
                } 
            }
            
            countStreak = 0;
            count = 0;
        }  
    }
    console.log(numbers);
    console.log(total);       
}
consecutiveNumber();
