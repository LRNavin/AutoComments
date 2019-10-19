private long toEpochNano(){
  long nod=time.toNanoOfDay();
  long offsetNanos=offset.getTotalSeconds() * NANOS_PER_SECOND;
  return nod - offsetNanos;
}
