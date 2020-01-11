<?php
    include 'Interface.php';
    include 'Shapes.php';
    include 'Circle.php';
    include 'Triangle.php';
    include 'Rectangle.php';
?>

<html>
    <head>
        <title>Shape Calculator</title>
        <script src="Validation.js"></script>
    </head>
    <body>
        <form action= "<?php $_SERVER['PHP_SELF'] ?>" onsubmit="return validate()" method="post">
            <fieldset>
                <legend>Circle</legend>
                Diameter : <input type="text" name="diameter" id="diameter" value="<?php if(isset($_POST['diameter'])) echo $_POST['diameter']?>"/>
                AreaChnagesto : <input type="text" name="areachangecircle" id="areachangecircle" value="<?php if(isset($_POST['areachangecircle'])) echo $_POST['areachangecircle']?>"/>%
            </fieldset>
            <fieldset>
                <legend>Rectangle</legend>
                Length : <input type="text" name="length" id="length" value="<?php if(isset($_POST['diameter'])) echo $_POST['length'] ?>"/>
                Width : <input type="text" name="width" id="width" value="<?php if(isset($_POST['diameter'])) echo $_POST['width'] ?>"/>
            </fieldset>
            <fieldset>
                <legend>Triangle</legend>
                Base : <input type="text" name="base" id="base" value="<?php if(isset($_POST['base'])) echo $_POST['base'] ?>"/>
                Height : <input type="text" name="height" id="height" value="<?php if(isset($_POST['height'])) echo $_POST['height'] ?>"/>
                AreaChnagesto : <input type="text" name="areachangetriangle" id="areachangetriangle" value="<?php if(isset($_POST['areachangetriangle'])) echo $_POST['areachangetriangle'] ?>"/>%
            </fieldset>
            <br>
            <button type="submit">Calculate</button>
        </form>

        <h3>Results:</h3>

        <?php
        if(isset($_POST['diameter'])) {
            if ($_POST['diameter']>0) {
                $diameter = $_POST['diameter'];
                $changecircleareato = $_POST['areachangecircle'];

                $mycircle = new Circle('Circle', $diameter);
                ?>
                <h2>Shape: <?php echo $mycircle->name ?></h2>
                Area: <?php echo $mycircle->CalculateArea(); ?>
                New Area: <?php echo $mycircle->Resize($changecircleareato); ?>
                New Diameter: <?php echo $mycircle->getdia(); ?>
                <?php
            }
            ?>
            <?php
            if ($_POST['length']>0 || $_POST['width']>0) {
                $length = $_POST['length'];
                $width = $_POST['width'];
                $myrectangle = new Rectangle('Rectangle', $length, $width);
                ?>

                <h2>Shape: <?php echo "$myrectangle->name" ?></h2>
                Area: <?php echo $myrectangle->CalculateArea(); ?>

                <?php
            }
            ?>
            <?php
            if ($_POST['base']>0 || $_POST['height']>0) {
                $base = $_POST['base'];
                $height = $_POST['height'];
                $changetriangleareato = $_POST['areachangetriangle'];

                $mytriangle = new Triangle('Triangle', $base, $height);
                ?>
                <h2>Shape: <?php echo "$mytriangle->name" ?></h2>
                Area: <?php echo $mytriangle->CalculateArea(); ?>
                New Area: <?php echo $mytriangle->Resize($changetriangleareato); ?>
                New Height: <?php echo $mytriangle->getheight(); ?>
                <?php
            }
        }
        ?>
    </body>
</html>


