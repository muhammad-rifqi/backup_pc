<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class AddNamaBarangToPenjualansTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::table('penjualans', function (Blueprint $table) {
             $table->string('nama_barang');
             $table->integer('jumlah_pesanan');
             $table->integer('harga_barang');
             $table->integer('foto_barang');
             $table->string('nama_supplier');
             $table->string('nama_pembeli');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::table('penjualans', function (Blueprint $table) {
            $table->dropColumn('nama_barang');
            $table->dropColumn('jumlah_pesanan');
            $table->dropColumn('harga_barang');
            $table->dropColumn('foto_barang');
            $table->dropColumn('nama_supplier');
            $table->dropColumn('nama_pembeli');
        });
    }
}
