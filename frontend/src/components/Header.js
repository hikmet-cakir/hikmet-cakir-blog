import './Header.css';

function Header() {
  return (
    <header class="header">
      <ul class="nav-links">
        <li><a href="/">Hikmet Cakir</a></li> 
        <li style={{float: 'right'}}><a href="/">Algorithm</a></li>
        <li style={{float: 'right'}}><a href="/">SQL</a></li> 
        <li style={{float: 'right'}}><a href="/">Spring</a></li> 
        <li style={{float: 'right'}}><a href="/">Java</a></li> 
      </ul>
    </header>
  );
}

export default Header