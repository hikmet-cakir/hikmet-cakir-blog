import './Header.css';

function Header() {
  return (
    <header class="header">
      <ul class="nav-links">
        <li><a href="/">Hikmet Cakir</a></li> 
        <li style={{float: 'right'}}><a href="/algorithm">Algorithm</a></li>
        <li style={{float: 'right'}}><a href="/sql">SQL</a></li> 
        <li style={{float: 'right'}}><a href="/spring">Spring</a></li> 
        <li style={{float: 'right'}}><a href="/java">Java</a></li> 
      </ul>
    </header>
  );
}

export default Header