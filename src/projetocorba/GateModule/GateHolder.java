package GateModule;

/**
* GateModule/GateHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from IDLGateModule.idl
* Segunda-feira, 15 de Outubro de 2018 18h40min26s GMT-03:00
*/

public final class GateHolder implements org.omg.CORBA.portable.Streamable
{
  public GateModule.Gate value = null;

  public GateHolder ()
  {
  }

  public GateHolder (GateModule.Gate initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GateModule.GateHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GateModule.GateHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GateModule.GateHelper.type ();
  }

}
