<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Input php handling - Get</title>
    </head>
    <body>
        <?php
            $date = $_GET['date'];
            $month = $_GET['month'];

            $string = "Your zodiac sign is: ";
            echo "Hello, ".$_GET['fName']." ".$_GET['lName']."!<br>";

            function MonthandDatevalidation()
            {
                global $month;
                global $date;
                switch($month)
                {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        if($date>=1 && $date<=31)
                            return 1;
                        else
                            return 2;
                        break;

                    case 2:
                        if($date>=1 && $date<=29)
                            return 1;
                        else
                            return 2;
                        break;

                    case 4: case 6: case 9: case 11:
                        if($date>=1 && $date<=30)
                            return 1;
                        else
                            return 2;
                        break;

                    default:
                        return 3;
                }
            }

            if(MonthandDatevalidation() == 1)
            {
                switch ($month)
                {
                    case 1:
                        if ($date <= 19)
                            echo $string."Capricorn";
                        else
                            echo $string."Aquarious";
                        break;

                    case 2:
                        if ($date <= 18)
                            echo $string."Aquarious";
                        else
                            echo $string."Pisces";
                        break;

                    case 3:
                        if ($date <= 19)
                            echo $string."Pisces";
                        else
                            echo $string."Aries";
                        break;

                    case 4:
                        if ($date <= 18)
                            echo $string."Aries";
                        else
                            echo $string."Taurus";
                        break;

                    case 5:
                        if ($date <= 20)
                            echo $string."Taurus";
                        else
                            echo $string."Gemini";
                        break;

                    case 6:
                        if ($date <= 20)
                            echo $string."Gemini";
                        else
                            echo $string."Cancer";
                        break;

                    case 7:
                        if ($date <= 22)
                            echo $string."Cancer";
                        else
                            echo $string."Leo";
                        break;

                    case 8:
                        if ($date <= 22)
                            echo $string."Leo";
                        else
                            echo $string."Virgo";
                        break;

                    case 9:
                        if ($date <= 22)
                            echo $string."Virgo";
                        else
                            echo $string."Libra";
                        break;

                    case 10:
                        if ($date <= 22)
                            echo $string."Libra";
                        else
                            echo $string."Scorpio";
                        break;

                    case 11:
                        if ($date <= 21)
                            echo $string."Scorpio";
                        else
                            echo $string."Sagittarius";
                        break;

                    case 12:
                        if ($date<= 21)
                            echo $string."Sagittarius";
                        else
                            echo $string."Capricorn";
                        break;
                }
            }
            elseif (MonthandDatevalidation() == 2)
                echo "Error!!!. Invalid Date.";
            elseif (MonthandDatevalidation() == 3)
                echo "Error!!!. Invalid month.";
        ?>
    </body>
</html>