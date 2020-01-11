<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/users', 'UsersController@index');
Route::post('/users', 'UsersController@index');
Route::patch('/users/{user}/{role}', 'RolesController@update');
Route::delete('/users/{user}/{role}', 'RolesController@destroy');
Route::patch('/users/{user}', 'UsersController@update');
Route::delete('/users/{user}', 'UsersController@destroy');
Route::get('/users/{user}/edit', 'UsersController@edit');

Route::resource('themes','ThemesController');
Route::resource('posts','PostsController');
Route::resource('comments','CommentsController');
Route::post('/posts/{post}/{user}','PostsController@likedpost');

Route::get('/ajaxcallnewpost/{post}','AjaxController@update');

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');
