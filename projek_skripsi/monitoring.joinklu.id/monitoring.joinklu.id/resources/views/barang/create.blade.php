@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Barang / Create</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/barang/store" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="nama_barang" class="form-control" placeholder="Nama Barang" required>
                        </div>
                        <div class="col">
                            <input type="text" name="stok_barang" class="form-control" placeholder="Stok Barang" required>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="harga_barang" class="form-control" placeholder="Harga Barang" required>
                        </div>
                        <div class="col">
                            <input type="file" name="foto_barang" class="form-control" placeholder="Foto Barang" required>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="deskripsi_barang" class="form-control" placeholder="Deskripsi Barang" required>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12 text-left">
                            <input type="submit" value="Simpan" class="btn btn-primary">
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
