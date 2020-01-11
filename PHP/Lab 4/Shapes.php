<?php

abstract class Shapes
{
    public $name;

    public function __construct($name)
    {
        $this->name = $name;
    }

    abstract public function CalculateArea();
}