@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">Pemesanan / Edit</div>
                <div class="card-body">
                    <form method="POST" action="/dashboard/pemesanan/update/{{$detail->id}}" enctype="multipart/form-data">
                    {{csrf_field()}}
                    <input type="hidden" id="nama_barang" name="nama_barang" value="{{$detail->nama_barang}}">
                    <input type="hidden" id="foto_barang" name="foto_barang" value="{{$detail->foto_barang}}">
                    <div class="form-row">
                        <div class="col">
                            <select name="id_barang" class="form-control" readonly>
                                <option value="--">Pilih Barang</option>
                                @foreach($data as $row)
                                    @if($row->id == $detail->id_barang)
                                    <option value="{{$row->id}}" selected>{{$row->nama_barang}}</option>
                                    @else
                                    <option value="{{$row->id}}">{{$row->nama_barang}}</option>
                                    @endif
                                @endforeach
                            </select>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                                <input type="text" name="harga_barang" id="harga_barang" class="form-control" placeholder="Harga Barang" value="{{$detail->harga_barang}}" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <img id="photo" src="{{url('upload/'.$detail->foto_barang)}}" width="200" alt="gambar barang" style="border:1px solid #ccc; padding:3px"/> <br /><br />
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <input type="number" name="jumlah_pesanan" id="jumlah_pesanan" class="form-control" placeholder="Jumlah Pesanan" value="{{$detail->jumlah_pesanan}}">
                        </div>
                        <div class="col">
                            <input type="text" name="session_id" id="session_id" class="form-control" placeholder="Session ID" value="{{$detail->session_id}}" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="form-row">
                        <div class="col">
                            <select name="id_pembeli" class="form-control" required>
                                <option value="--">Pilih Pembeli</option>
                                @foreach($beli as $rows)
                                    @if($rows->id == $detail->id_pembeli)
                                        <option value="{{$rows->id}}" selected>{{$rows->nama}}</option>
                                    @else
                                        <option value="{{$rows->id}}">{{$rows->nama}}</option>
                                    @endif
                                @endforeach
                            </select>
                        </div>
                        <div class="col">
                            <label>Status Pesanan</label> &nbsp;
                                @if($detail->status_barang == 'N')
                                <input type="radio" name="status_barang" id="status_barang" value="0" checked> N &nbsp;
                                <input type="radio" name="status_barang" id="status_barang" value="1"> Y &nbsp;
                                @else
                                <input type="radio" name="status_barang" id="status_barang" value="0"> N &nbsp;
                                <input type="radio" name="status_barang" id="status_barang" value="1" checked> Y &nbsp;
                                @endif
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