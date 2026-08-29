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

Auth::routes();

Route::get('/dashboard/home', 'HomeController@index')->name('home');

Route::get('/dashboard/pembeli', 'PembeliController@index');
Route::get('/dashboard/pembeli/create', 'PembeliController@create');
Route::post('/dashboard/pembeli/store', 'PembeliController@store');
Route::get('/dashboard/pembeli/edit/{id}', 'PembeliController@edit');
Route::post('/dashboard/pembeli/update/{id}', 'PembeliController@update');
Route::get('/dashboard/pembeli/delete/{id}', 'PembeliController@destroy');

Route::get('/dashboard/barang', 'BarangController@index');
Route::get('/dashboard/barang/create', 'BarangController@create');
Route::post('/dashboard/barang/store', 'BarangController@store');
Route::get('/dashboard/barang/edit/{id}', 'BarangController@edit');
Route::post('/dashboard/barang/update/{id}', 'BarangController@update');
Route::get('/dashboard/barang/delete/{id}/{foto}', 'BarangController@destroy');

Route::get('/dashboard/penjualan', 'PenjualanController@index');
Route::get('/dashboard/penjualan/create', 'PenjualanController@create');
Route::post('/dashboard/penjualan/store', 'PenjualanController@store');
Route::get('/dashboard/penjualan/edit/{id}', 'PenjualanController@edit');
Route::get('/dashboard/penjualan/show/{date}', 'PenjualanController@show');
Route::post('/dashboard/penjualan/update/{id}', 'PenjualanController@update');
Route::get('/dashboard/penjualan/delete/{id}', 'PenjualanController@destroy');

Route::get('/dashboard/laporan', 'LaporanController@index');
Route::get('/dashboard/laporan/create', 'LaporanController@create');
Route::post('/dashboard/laporan/store', 'LaporanController@store');
Route::get('/dashboard/laporan/edit/{id}', 'LaporanController@edit');
Route::get('/dashboard/laporan/show/{date}', 'LaporanController@show');
Route::post('/dashboard/laporan/update/{id}', 'LaporanController@update');
Route::get('/dashboard/laporan/delete/{id}', 'LaporanController@destroy');

Route::get('/dashboard/supplier', 'SupplierController@index');
Route::get('/dashboard/supplier/create', 'SupplierController@create');
Route::post('/dashboard/supplier/store', 'SupplierController@store');
Route::get('/dashboard/supplier/edit/{id}', 'SupplierController@edit');
Route::post('/dashboard/supplier/update/{id}', 'SupplierController@update');
Route::get('/dashboard/supplier/delete/{id}', 'SupplierController@destroy');

Route::get('/dashboard/kategori', 'KategoriController@index');
Route::get('/dashboard/kategori/create', 'KategoriController@create');
Route::post('/dashboard/kategori/store', 'KategoriController@store');
Route::get('/dashboard/kategori/edit/{id}', 'KategoriController@edit');
Route::post('/dashboard/kategori/update/{id}', 'KategoriController@update');
Route::get('/dashboard/kategori/delete/{id}', 'KategoriController@destroy');

Route::get('/dashboard/pemesanan', 'PemesananController@index');
Route::get('/dashboard/pemesanan/create', 'PemesananController@create');
Route::post('/dashboard/pemesanan/store', 'PemesananController@store');
Route::get('/dashboard/pemesanan/views/{id}', 'PemesananController@views');
Route::get('/dashboard/pemesanan/edit/{id}', 'PemesananController@edit');
Route::post('/dashboard/pemesanan/update/{id}', 'PemesananController@update');
Route::get('/dashboard/pemesanan/delete/{id}', 'PemesananController@destroy');
