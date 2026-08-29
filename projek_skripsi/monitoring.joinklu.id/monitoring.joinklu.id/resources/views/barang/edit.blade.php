@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Barang / Edit</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/barang/update/{{$data->id}}" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="nama_barang" class="form-control" placeholder="Nama Barang" value="{{$data->nama_barang}}">
                        </div>
                        <div class="col">
                            <input type="text" name="stok_barang" class="form-control" placeholder="Stok Barang" value="{{$data->stok_barang}}"equired>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="harga_barang" class="form-control" placeholder="Harga Barang" value="{{$data->harga_barang}}">
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                                <img src="{{url('upload/'.$data->foto_barang)}}" width="200" alt="gambar barang" style="border:1px solid #ccc; padding:3px;" /> <br />
                                <input type="file" name="foto_barang" class="form-control" placeholder="Foto Barang">
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="deskripsi_barang" class="form-control" placeholder="Deskripsi Barang" value="{{$data->deskripsi_barang}}">
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
