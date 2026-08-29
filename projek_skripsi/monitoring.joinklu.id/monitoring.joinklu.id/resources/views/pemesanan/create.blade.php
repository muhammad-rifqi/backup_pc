@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Pemesanan / Create</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/pemesanan/store" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <input type="hidden" id="nama_barang" name="nama_barang" value="">
                    <div class="form-row">
                        <div class="col">
                            <select name="id_barang" class="form-control" onchange="pilih(this.value)" required>
                                <option value="--">Pilih Barang</option>
                                @foreach($data as $row)
                                    <option value="{{$row->id}}">{{$row->nama_barang}}</option>
                                @endforeach
                            </select>
                        </div>
                        <div class="col">
                            <input type="text" name="stok_barang" id="stok_barang" class="form-control" placeholder="Stok Barang" value="" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                                <input type="text" name="harga_barang" id="harga_barang" class="form-control" placeholder="Harga Barang" value="" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <img id="photo" src="/upload/default.jpeg" width="200" alt="gambar barang" style="border:1px solid #ccc; padding:3px"/> <br /><br />
                            <input type="text" name="foto_barang" id="foto_barang" class="form-control" placeholder="Foto Barang" value="" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="number" name="jumlah_pesanan" id="jumlah_pesanan" class="form-control" placeholder="Jumlah Pesanan" value="">
                        </div>
                        <div class="col">
                            <input type="text" name="session_id" id="session_id" class="form-control" placeholder="Session ID" value="{{$sess}}" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <select name="id_pembeli" class="form-control" required>
                                <option value="--">Pilih Pembeli</option>
                                @foreach($beli as $rows)
                                    <option value="{{$rows->id}}">{{$rows->nama}}</option>
                                @endforeach
                            </select>
                        </div>
                        <div class="col">
                            <label>Status Pesanan</label> &nbsp;
                                <input type="radio" name="status_barang" id="status_barang" value="0" checked> N &nbsp;
                                <input type="radio" name="status_barang" id="status_barang" value="1"> Y &nbsp;
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

<script>
    function pilih(e){
            fetch('/dashboard/pemesanan/views/'+e)
            .then(response => response.json())
            .then((data)=> { 
                document.getElementById("nama_barang").value = data?.nama_barang
                document.getElementById("stok_barang").value = data?.stok_barang
                document.getElementById("harga_barang").value = data?.harga_barang
                document.getElementById("foto_barang").value = data?.foto_barang
                document.getElementById("photo").setAttribute('src','/upload/'+data?.foto_barang);
            });
    }
</script>