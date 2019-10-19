@Transactional public Role createRoleWithPermissions(Role VAR0,Set<Long> VAR1){
  Role current=findRoleByRoleName(VAR0.getRoleName());
  Preconditions.checkState(current == null,"Role %s already exists!",VAR0.getRoleName());
  Role createdRole=VAR0Repository.save(VAR0);
  if (!CollectionUtils.isEmpty(VAR1)) {
    Iterable<RolePermission> VAR0Permissions=FluentIterable.from(VAR1).transform(null);
    VAR0PermissionRepository.save(VAR0Permissions);
  }
  return createdRole;
}
