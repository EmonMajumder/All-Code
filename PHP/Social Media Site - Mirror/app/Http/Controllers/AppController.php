<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\User;
use http\Cookie;

class AppController extends Controller
{
    //

    public function __construct()
    {
        $this->middleware('auth');
    }
}
